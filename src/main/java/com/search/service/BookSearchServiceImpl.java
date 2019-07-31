package com.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.dao.BookDetailsDao;
import com.search.model.Book;

@Service
public class BookSearchServiceImpl implements BookSearchService {

	@Autowired(required=true)
	private BookDetailsDao dao;
	public List<Book> retriveBooks(Integer bookId) {
		// TODO Auto-generated method stub
		return dao.findBooks(bookId);
	}

}
