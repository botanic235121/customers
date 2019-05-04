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

@WebServlet("/information")
public class MainServlet extends HttpServlet {

    private ClientsDaoImpl clientsDaoImp = new ClientsDaoImpl();

    private static final String ADD_CLIENT_VIEW = "client/addClient.ftl";
    private static final String UPDATE_CLIENT_VIEW = "client/updateClient.ftl";
    private static final String LIST_CLIENTS_VIEW = "client/listClients.ftl";

    private static final String INFORMATION_UPDATED_HTML = "InformationUpdated.html";

    private static final String ADD_CLIENT_ACTION = "addAction";
    private static final String UPDATE_CLIENT_ACTION = "updateAction";
    private static final String DELETE_CLIENT_ACTION = "deleteAction";
    private static final String LIST_CLIENTS_ACTION = "listClients";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = "";

        String action = request.getParameter("action");
        switch (action) {
            case ADD_CLIENT_ACTION:
                path = ADD_CLIENT_VIEW;
                break;
            case UPDATE_CLIENT_ACTION:
                int id_client_update = Integer.parseInt(request.getParameter("id_client"));
                Client update_client = clientsDaoImp.getClientById(id_client_update);
                request.setAttribute("client", update_client);
                path = UPDATE_CLIENT_VIEW;
                break;
            case DELETE_CLIENT_ACTION:
                int id_client_delete = Integer.parseInt(request.getParameter("id_client"));
                clientsDaoImp.deleteClient(id_client_delete);
                path = INFORMATION_UPDATED_HTML;
                break;
            case LIST_CLIENTS_ACTION:
                List<Client> clients = clientsDaoImp.getAllClients();
                request.setAttribute("clients", clients);
                path = LIST_CLIENTS_VIEW;
                break;
        }

        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String path = "";

        String action = req.getParameter("action");

        switch (action) {
            case UPDATE_CLIENT_ACTION:
                Client update_client = new Client();
                update_client.setId(Integer.parseInt(req.getParameter("id")));
                update_client.setFirstName(req.getParameter("firstName"));
                update_client.setLastName(req.getParameter("lastName"));
                clientsDaoImp.updateClient(update_client);
                path = INFORMATION_UPDATED_HTML;
                break;
            case ADD_CLIENT_ACTION:
                Client add_client = new Client();
                add_client.setFirstName(req.getParameter("firstName"));
                add_client.setLastName(req.getParameter("lastName"));
                clientsDaoImp.addClient(add_client);
                path = INFORMATION_UPDATED_HTML;
                break;
        }
        resp.sendRedirect(path);

    }
}
