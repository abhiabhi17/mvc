package com.search.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.search.model.Book;
import com.search.service.BookSearchService;
import com.search.views.ExcelUserListReportView;
import com.search.views.PdfUserListReportView;

@Controller

public class BookSearchController {
	
	@Autowired(required=true)
	
	private BookSearchService searchservice;

	
	
	@RequestMapping(value="/bookSearch.htm")
	public String booksearch()
	{
		return "booksearch";
	}

	@RequestMapping(value="/searchBooks.htm",method=RequestMethod.POST)
	public String searchbooks(HttpServletRequest req,Model model)



	
	{
		Integer bookId=null;
		String id=req.getParameter("bookId");
		if(id!= null && id.equals(" "))
		{
			bookId = Integer.parseInt(id);
		}
		
		List<Book> books=searchservice.retriveBooks(bookId);
		model.addAttribute("books",books);
		
		
		return "booksearch";
	}
	
	
	
	 
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	 public  ModelAndView userListReport(HttpServletRequest req, HttpServletResponse res){
	  
	  String typeReport = req.getParameter("type");
	  
	  Integer bookId = null;
	List<Book> books=searchservice.retriveBooks(bookId);
	  
	  if(typeReport != null && typeReport.equals("xls")){
	   return new ModelAndView(new ExcelUserListReportView(), "userList", books);
	  } else if(typeReport != null && typeReport.equals("pdf")){
	   return new ModelAndView(new PdfUserListReportView(), "userList", books);
	  }
	  
	  return new ModelAndView("booksearch", "userList", books);
	 }
	
}
