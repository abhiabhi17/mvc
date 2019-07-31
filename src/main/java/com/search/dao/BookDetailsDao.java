package com.search.dao;

import java.util.List;

import com.search.model.Book;




public interface BookDetailsDao{

	public List<Book> findBooks(Integer bookId);
}
