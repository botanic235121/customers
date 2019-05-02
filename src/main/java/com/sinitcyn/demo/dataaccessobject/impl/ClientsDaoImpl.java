package com.sinitcyn.demo.dataaccessobject.impl;

import com.sinitcyn.demo.dataaccessobject.ClientDao;
import com.sinitcyn.demo.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ClientsDaoImpl implements ClientDao {

    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "root");
            properties.setProperty("characterEncoding", "UTF-8");
            /*properties.setProperty("useUnicode", "true");*/
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", properties);
            System.out.println("Got our connection");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("select id_client, first_name, last_name from clients "
                    + "where id_client=?");
            pr.setInt(1, id);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt(1));
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
            }

        } catch (SQLException e) {
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return client;
    }

    @Override
    public void addClient(Client client) {
        Connection con = getConnection();

        try {
            PreparedStatement pr = con.prepareStatement("insert into " +
                    "clients(first_name, last_name) values (?,?)");
            pr.setString(1, client.getFirstName());
            pr.setString(2, client.getLastName());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateClient(Client client) {
        Connection con = getConnection();

        try {
            PreparedStatement pr = con.prepareStatement("update clients set "
                    + "first_name = ?, last_name = ? where id_client=?");
            pr.setString(1, client.getFirstName());
            pr.setString(2, client.getLastName());
            pr.setInt(3, client.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClient(int id) {
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("delete from clients "
                    + "where id_client = ?");
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        Client client = null;
        Connection con = getConnection();

        try {
            PreparedStatement pr = con.prepareStatement("select * from clients");
            ResultSet resultSet = pr.executeQuery();

            while (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt(1));
                client.setFirstName(resultSet.getString(2));
                client.setLastName(resultSet.getString(3));
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    //Just test CRUD operation
   /* public static void main(String[] args) {
        ClientsDaoImpl clientsDao = new ClientsDaoImpl();
        Client clients = new Client();
        clients.setFirstName("Bob");
        clients.setLastName("Marley");
        clientsDao.createClient(clients);
        Client clients = clientsDao.getClientById(4);
        System.out.println(clients);
        System.out.println(clientsDao.getAllClients());
        System.out.println(clientsDao.updateClient(clients));
        clientsDao.deleteClient(6);

    }*/

}
