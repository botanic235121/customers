package com.sinitcyn.demo.dataaccessobject;

import com.sinitcyn.demo.entity.Client;
import com.sinitcyn.demo.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getAllOrdersByClient(Client client);

    void addOrderByClient(Order order, Client client);

    void deleteOrder(int id);

    void updateOrder(Order order);

    Order getOrderById(int id);

}
