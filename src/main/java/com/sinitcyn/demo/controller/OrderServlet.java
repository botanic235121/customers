package com.sinitcyn.demo.controller;

import com.sinitcyn.demo.dataaccessobject.impl.ClientsDaoImpl;
import com.sinitcyn.demo.dataaccessobject.impl.OrdersDaoImpl;
import com.sinitcyn.demo.entity.Client;
import com.sinitcyn.demo.entity.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    private ClientsDaoImpl clientsDaoImp = new ClientsDaoImpl();
    private OrdersDaoImpl ordersDaoImp = new OrdersDaoImpl();

    private static final String ADD_ORDER_VIEW = "order/addOrder.ftl";
    private static final String UPDATE_ORDER_VIEW = "order/updateOrder.ftl";
    private static final String LIST_ORDERS_VIEW = "order/listOrders.ftl";

    private static final String ADD_ORDER_ACTION = "addOrder";
    private static final String UPDATE_ORDER_ACTION = "updateOrder";
    private static final String DELETE_ORDER_ACTION = "deleteOrder";
    private static final String LIST_ORDERS_ACTION = "showOrder";

    private static final String INFORMATION_UPDATED_HTML = "InformationUpdated.html";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = "";

        String option = request.getParameter("option");

        switch (option) {
            case ADD_ORDER_ACTION:
                int id_client_for_add_order = Integer.parseInt(request.getParameter("id_client"));
                Client client_for_add_order = clientsDaoImp.getClientById(id_client_for_add_order);
                request.setAttribute("client", client_for_add_order);
                path = ADD_ORDER_VIEW;
                break;
            case UPDATE_ORDER_ACTION:
                int id_client_for_update_order = Integer.parseInt(request.getParameter("id_client"));
                Client client_for_update_order = clientsDaoImp.getClientById(id_client_for_update_order);
                int id_order_for_update = Integer.parseInt(request.getParameter("id_order"));
                Order order_for_update = ordersDaoImp.getOrderById(id_order_for_update);
                request.setAttribute("client", client_for_update_order);
                request.setAttribute("order", order_for_update);
                path = UPDATE_ORDER_VIEW;
                break;
            case DELETE_ORDER_ACTION:
                int id_order_for_delete = Integer.parseInt(request.getParameter("id_order"));
                ordersDaoImp.deleteOrder(id_order_for_delete);
                path = INFORMATION_UPDATED_HTML;
                break;
            case LIST_ORDERS_ACTION:
                int id_client_for_show_orders = Integer.parseInt(request.getParameter("id_client"));
                Client client = clientsDaoImp.getClientById(id_client_for_show_orders);
                List<Order> orders = ordersDaoImp.getAllOrdersByClient(client);
                request.setAttribute("client", client);
                request.setAttribute("orders", orders);
                path = LIST_ORDERS_VIEW;
                break;
        }
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = "";

        String option = request.getParameter("option");

        switch (option) {
            case ADD_ORDER_ACTION:
                int id_client_for_add_order = Integer.parseInt(request.getParameter("id"));
                Client client_for_add_order = clientsDaoImp.getClientById(id_client_for_add_order);
                Order add_order = new Order();
                add_order.setName(request.getParameter("orderName"));
                ordersDaoImp.addOrderByClient(add_order, client_for_add_order);
                path = INFORMATION_UPDATED_HTML;
                break;
            case UPDATE_ORDER_ACTION:
                int id_order_for_update = Integer.parseInt(request.getParameter("id_order"));
                String name_order = request.getParameter("name_order");
                Order update_order = new Order();
                update_order.setId(id_order_for_update);
                update_order.setName(name_order);
                ordersDaoImp.updateOrder(update_order);
                path = INFORMATION_UPDATED_HTML;
                break;
        }

        response.sendRedirect(path);

    }
}
