package com.search.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.search.model.Book;

public class PdfUserListReportView extends AbstractPdfView  {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 response.setHeader("Content-Disposition", "attachment; filename=\"user_list.pdf\"");
		  
		  @SuppressWarnings("unchecked")
		  List<Book> list = (List<Book>) model.get("userList");
		  Table table = new Table(4);
		  table.addCell("ID");
		  table.addCell("BookName");
		  table.addCell("AuthorName");
		  table.addCell("Price");
		  for(Book book : list){
			   table.addCell(String.valueOf(book.getBookId()));
			   table.addCell(book.getBookName());
			   table.addCell(book.getAuthorName());
			   
			   
			  }
		  document.add(table);
		
	}

}
