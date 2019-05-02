package com.sinitcyn.demo.controller;


import com.sinitcyn.demo.dataaccessobject.impl.ClientsDaoImpl;
import com.sinitcyn.demo.entity.Client;


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

    private static final String ADD_CLIENT_VIEW = "addClient.ftl";
    private static final String UPDATE_CLIENT_VIEW = "updateClient.ftl";
    private static final String LIST_CLIENTS_VIEW = "listClients.ftl";

    private static final String CLIENT_ADDED_VIEW = "clientAdded.html";
    private static final String CLIENT_DELETED_VIEW = "clientDeleted.html";
    private static final String CLIENT_UPDATED_VIEW = "clientUpdated.html";

    private static final String ADD_ACTION = "addAction";
    private static final String UPDATE_ACTION = "updateAction";
    private static final String DELETE_ACTION = "deleteAction";
    private static final String LIST_ACTION = "listClients";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = "";

        String action = request.getParameter("action");
        switch (action) {
            case ADD_ACTION:
                path = ADD_CLIENT_VIEW;
                break;
            case LIST_ACTION:
                List<Client> clients = clientsDaoImp.getAllClients();
                request.setAttribute("clients", clients);
                path = LIST_CLIENTS_VIEW;
                break;
            case UPDATE_ACTION:
                int id_client_update = Integer.parseInt(request.getParameter("id_client"));
                Client update_client = clientsDaoImp.getClientById(id_client_update);
                request.setAttribute("client", update_client);
                path = UPDATE_CLIENT_VIEW;
                break;
            case DELETE_ACTION:
                int id_client_delete = Integer.parseInt(request.getParameter("id_client"));
                clientsDaoImp.deleteClient(id_client_delete);
                path = CLIENT_DELETED_VIEW;
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
            case UPDATE_ACTION:
                Client update_client = new Client();
                update_client.setId(Integer.parseInt(req.getParameter("id")));
                update_client.setFirstName(req.getParameter("firstName"));
                update_client.setLastName(req.getParameter("lastName"));

                clientsDaoImp.updateClient(update_client);
                path = CLIENT_UPDATED_VIEW;
                break;
            case ADD_ACTION:
                Client add_client = new Client();
                add_client.setFirstName(req.getParameter("firstName"));
                add_client.setLastName(req.getParameter("lastName"));

                clientsDaoImp.addClient(add_client);
                path = CLIENT_ADDED_VIEW;
                break;

        }
        resp.sendRedirect(path);

    }
}
