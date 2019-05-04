package com.sinitcyn.demo.dataaccessobject.impl;

import com.sinitcyn.demo.dataaccessobject.OrderDao;
import com.sinitcyn.demo.dataaccessobject.connection.DBConnection;
import com.sinitcyn.demo.entity.Client;
import com.sinitcyn.demo.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OrderDao {

    @Override
    public List<Order> getAllOrdersByClient(Client client) {
        Connection con = DBConnection.getConnection();
        List<Order> orders = new ArrayList<>();
        Order order;
        try {
            PreparedStatement ps = con.prepareStatement("select name , id_order from orders where id_client=?");
            ps.setInt(1, client.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order = new Order();
                order.setName(resultSet.getString(1));
                order.setId(resultSet.getInt(2));
                order.setClient(client);
                orders.add(order);
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
        return orders;
    }

    @Override
    public void addOrderByClient(Order order, Client client) {
        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("insert into orders (name, id_client) values (?,?)");
            ps.setString(1, order.getName());
            ps.setInt(2, client.getId());
            ps.executeUpdate();
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
    public void deleteOrder(int id) {
        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("delete from orders where id_order = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
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
    public void updateOrder(Order order) {
        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("update orders set name = ? where id_order = ?");
            ps.setString(1, order.getName());
            ps.setInt(2, order.getId());
            ps.executeUpdate();
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
    public Order getOrderById(int id) {
        Connection con = DBConnection.getConnection();
        Order order = new Order();
        try {
            PreparedStatement ps = con.prepareStatement("select name from orders where id_order = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                order.setName(rs.getString(1));
            }
            order.setId(id);

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

        return order;
    }
}
