package com.search.views;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.search.model.Book;

public class ExcelUserListReportView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-disposition", "attachment; filename=\"user_list.xls\"");
		  
		  @SuppressWarnings("unchecked")
		  List<Book> list = (List<Book>) model.get("userList");
		  Sheet sheet = workbook.createSheet("User List");
		  
		  Row header = sheet.createRow(0);
		  header.createCell(0).setCellValue("BookID");
		  header.createCell(1).setCellValue("BookName");
		  header.createCell(2).setCellValue("AuthorName");
		  header.createCell(3).setCellValue("Price");
		  
		  int rowNum = 1;
		  for(Book book:list)
		  {
			   Row row = sheet.createRow(rowNum++);
			   row.createCell(0).setCellValue(book.getBookId());
			   row.createCell(1).setCellValue(book.getBookName());
			   row.createCell(2).setCellValue(book.getAuthorName());
			   row.createCell(3).setCellValue(book.getBookPrice());
			  }
		
	}

}
