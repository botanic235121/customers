package com.sinitcyn.demo.controller;

import com.sinitcyn.demo.excelTables.ClientToExcelTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/excel")

public class ExcelServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=list_clients.xlsx");
            XSSFWorkbook wb = new ClientToExcelTable().createTable();
            ServletOutputStream os = response.getOutputStream();
            wb.write(os);
            wb.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
