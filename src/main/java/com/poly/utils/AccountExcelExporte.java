package com.poly.utils;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poly.entity.nhanvien;


import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class AccountExcelExporte {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<nhanvien> listAccounts;
     
   
    public AccountExcelExporte(List<nhanvien> listAccounts) {
        this.listAccounts = listAccounts;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Accounts");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Họ và tên", style);      
        createCell(row, 1, "Email", style);       
        createCell(row, 2, "Địa chỉ", style);    
        createCell(row, 3, "Số điện thoại", style);
        createCell(row, 4, "Ngày vào làm", style);
        createCell(row, 5, "Chức vụ", style);
        
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value == null) {
            cell.setCellValue(""); // Set an empty string for null values, adjust as per your requirement
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
        	
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue(String.valueOf(value)); // Use String.valueOf to handle non-standard types
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (nhanvien user : listAccounts) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, user.getHoten(), style);
            createCell(row, columnCount++, user.getEmail(), style);
            createCell(row, columnCount++, user.getDiachi(), style);
            createCell(row, columnCount++, user.getSdt(), style);
            createCell(row, columnCount++, user.getNgayvaolam(), style);
            if(user.getChucvu() == null){
                String chucVu = "";
                createCell(row, columnCount++, chucVu, style);
            } else if(user.getChucvu() == 0) {
                String chucVu = "Nhân viên bán vé";
                createCell(row, columnCount++, chucVu, style);
            } else if(user.getChucvu() == 1) {
                String chucVu = "Nhân viên bán nước";
                createCell(row, columnCount++, chucVu, style);
            } else if(user.getChucvu() == 2) {
                String chucVu = "Nhân viên tiếp tân";
                createCell(row, columnCount++, chucVu, style);
            }
            
           
           
           
            
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
    }
}
