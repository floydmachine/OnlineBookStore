package com.ars.pro1.dao;

import java.util.List;

import com.ars.pro1.model.Book;

public interface BookDao {

	public void addbook(Book b);

	public void updatebook(Book b);

	public void removebook(int id);
	
	public List<Book> listBook();
	
	public List<Book> categoryBook(String name);

	public Book getBookById(int id);
}
