package com.search.service;
import java.util.List;

import com.search.model.Book;
public interface BookSearchService {

	public List<Book> retriveBooks(Integer bookId);
}
