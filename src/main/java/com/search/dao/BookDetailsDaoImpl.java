package com.search.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.search.dao.BookDetailsDao;
import com.search.model.Book;
import com.search.util.ConnectionManager;

import java.sql.Connection;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@Repository
public class BookDetailsDaoImpl implements BookDetailsDao{

	


	public List<Book> findBooks(Integer bookId) {
		
		

		             List<Book> books =new ArrayList();
		 
		 StringBuffer bookSearchSql=new StringBuffer("SELECT *FROM BOOK_DETAILS ");
		 
		try {
			
			/* Connection con = ConnectionManager.getConnection(); */
			
			
			
			  Class.forName("com.mysql.jdbc.Driver"); 
			  Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/search","root","");
			
			  if(bookId!=null)
				{
					bookSearchSql= bookSearchSql.append(" WHERE BOOK_ID = " +bookId);
				
					
					
				}
			
			
			PreparedStatement ptsmt=con.prepareStatement(bookSearchSql.toString());
			System.out.println(bookSearchSql.toString());
		
			ResultSet rs=ptsmt.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBookId(rs.getInt("Book_id"));
				b.setBookName(rs.getString("BOOK_Name"));
				b.setAuthorName(rs.getString("Author_Name"));
				b.setBookPrice(rs.getInt("Book_price"));
				books.add(b);
				
			}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		
	
		return books;
		
		
		
		             
  
	}

	

}
