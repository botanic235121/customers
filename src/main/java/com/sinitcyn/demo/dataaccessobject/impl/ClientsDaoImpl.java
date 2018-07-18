package com.sinitcyn.demo.dataaccessobject.impl;

import com.sinitcyn.demo.dataaccessobject.ClientsDao;
import com.sinitcyn.demo.entity.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDaoImpl implements ClientsDao {

    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
            System.out.println("Got our connection");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public int createClient(Clients clients) {
        Connection con = getConnection();

        try {
            PreparedStatement pr = con.prepareStatement("insert into " +
                    "clients(first_name, last_name) values (?,?)");
            pr.setString(1, clients.getFirstName());
            pr.setString(2, clients.getLastName());
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            return 0;

        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /*@Override
    public int editClients(Clients clients) {
        int result = 0;
        Connection con = getConnection();

        try {
            PreparedStatement pr = con.prepareStatement("update clients set "
                    + "first_name = ?, last_name = ?");
            pr.setString(1, clients.getFirstName());
            pr.setString(2, clients.getLastName());
            result = pr.executeUpdate();
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
        return result;
    }*/

    @Override
    public void deleteClients(int id) {
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
    public Clients getClientById(int id) {
        Clients client = null;
        Connection con = getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("select id_client, first_name, last_name from clients "
                    + "where id_client=?");
            pr.setInt(1, id);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                client = new Clients();
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
    public List<Clients> getAllClients() {
        List<Clients> clients = new ArrayList<>();
        Clients client = null;
        Connection con = getConnection();

        try {
            PreparedStatement pr = con.prepareStatement("select * from clients");
            ResultSet resultSet = pr.executeQuery();

            while (resultSet.next()) {
                client = new Clients();
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
        Clients clients = new Clients();
        clients.setFirstName("Bob");
        clients.setLastName("Marley");
        clientsDao.createClient(clients);
        Clients clients = clientsDao.getClientById(4);
        System.out.println(clients);
        System.out.println(clientsDao.getAllClients());
        System.out.println(clientsDao.editClients(clients));
        clientsDao.deleteClients(6);

    }*/

}
