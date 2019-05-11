package com.sinitcyn.demo.excelTables;

import com.sinitcyn.demo.dataaccessobject.impl.ClientsDaoImpl;
import com.sinitcyn.demo.entity.Client;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ClientToExcelTable {

    private ClientsDaoImpl clientsDaoImp = new ClientsDaoImpl();
    private List<Client> listClients = clientsDaoImp.getAllClients();

    public XSSFWorkbook createTable() {
        //create table
        XSSFWorkbook wb = new XSSFWorkbook();
        //create sheet
        XSSFSheet sheet = wb.createSheet("Database");
        //create row for heads
        Row headRow = sheet.createRow(3);
        //create cells for heads
        Cell headCell;
        //create font for heads
        Font fontHead = wb.createFont();
        fontHead.setFontHeightInPoints((short) 16);
        fontHead.setFontName("Courier New");
        fontHead.setBold(true);
        //create cells style for head
        CellStyle styleHead = wb.createCellStyle();
        styleHead.setBorderBottom(BorderStyle.THICK);
        styleHead.setBorderLeft(BorderStyle.THICK);
        styleHead.setBorderRight(BorderStyle.THICK);
        styleHead.setBorderTop(BorderStyle.THICK);
        styleHead.setAlignment(HorizontalAlignment.CENTER);
        styleHead.setVerticalAlignment(VerticalAlignment.CENTER);
        styleHead.setFont(fontHead);
        //column width
        sheet.setColumnWidth(0, 2000);
        sheet.setColumnWidth(1, 8000);
        sheet.setColumnWidth(2, 8000);


        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    createCell(headRow, 0, "id", styleHead);
                    break;
                case 1:
                    createCell(headRow, 1, "Firstname", styleHead);
                    break;
                case 2:
                    createCell(headRow, 2, "Lastname", styleHead);
                    break;

            }
        }
        //create font for cells
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 14);
        font.setFontName("Courier New");
        font.setItalic(true);

        //create cells style
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(font);


        for (int i = 0; i < listClients.size(); i++) {
            Row row = sheet.createRow(i + 4);
            for (int j = 0; j < 3; j++) {
                if (j == 0) createCell(row, j, String.valueOf(listClients.get(i).getId()), style);
                if (j == 1) createCell(row, j, listClients.get(i).getFirstName(), style);
                if (j == 2) createCell(row, j, listClients.get(i).getLastName(), style);
            }
        }
        return wb;
    }

    private static void createCell(Row row, int column, String cellValue, CellStyle cellStyle) {
        Cell cell = row.createCell(column);
        cell.setCellValue(cellValue);
        cell.setCellStyle(cellStyle);
    }
}


