package com.sinitcyn.demo.controller;

import com.sinitcyn.demo.dataaccessobject.ClientsDao;
import com.sinitcyn.demo.dataaccessobject.impl.ClientsDaoImpl;
import com.sinitcyn.demo.entity.Clients;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    private ClientsDaoImpl clientsDaoImp = new ClientsDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*PrintWriter out = response.getWriter();
        out.print("<h1>Hello Servlet</h1>");
        request.setAttribute("name", "Friends");*/

        String id_client = request.getParameter("id_client");
        if (id_client != null) {
            Clients client = clientsDaoImp.getClientById(Integer.parseInt(id_client));
            request.setAttribute("client", client);
        }

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
