package com.ars.pro1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.pro1.dao.BookDao;
import com.ars.pro1.model.Book;
import com.ars.pro1.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional
	public void addbook(Book b) {
		this.bookDao.addbook(b);
	}

	@Override
	@Transactional
	public void updatebook(Book b) {
		this.bookDao.updatebook(b);
	}

	@Override
	@Transactional
	public void removebook(int id) {
		this.bookDao.removebook(id);
	}

	@Override
	@Transactional
	public List<Book> listBook() {
		return this.bookDao.listBook();
	}

	@Override
	@Transactional
	public Book getBookById(int id) {
		return this.bookDao.getBookById(id);
	}

  @Override
  @Transactional
  public List<Book> categoryBook(String name)
  {
    
    return this.bookDao.categoryBook(name);
  }

}
