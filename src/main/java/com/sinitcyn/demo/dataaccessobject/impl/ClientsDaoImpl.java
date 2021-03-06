package com.sinitcyn.demo.dataaccessobject.impl;

import com.sinitcyn.demo.dataaccessobject.ClientDao;
import com.sinitcyn.demo.dataaccessobject.connection.DBConnection;
import com.sinitcyn.demo.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDaoImpl implements ClientDao {

    @Override
    public Client getClientById(int id) {
        Client client = null;
        Connection con = DBConnection.getConnection();
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
        Connection con = DBConnection.getConnection();

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
        Connection con = DBConnection.getConnection();

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
        Connection con = DBConnection.getConnection();
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
        Connection con = DBConnection.getConnection();

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
        return clients;
    }
}
