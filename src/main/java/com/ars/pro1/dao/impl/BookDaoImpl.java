package com.ars.pro1.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.pro1.dao.BookDao;
import com.ars.pro1.model.Book;

@Repository
public class BookDaoImpl implements BookDao {
  private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addbook(Book b) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.persist(b);
		logger.info("Book added successfully,Book Details="+b);
	}

	@Override
	public void updatebook(Book b) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(b);
		logger.info("Book updated successfully, Book Details="+b);
	}

	@Override
	public void removebook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.load(Book.class, new Integer(id));
		if (null != b) {
			session.delete(b);
		}
		logger.info("Book deleted successfully, Book Details="+b);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBook() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> booksList = session.createQuery("from Book").list();
    return booksList;
  }

	@Override
	public Book getBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.load(Book.class, new Integer(id));
    logger.info("Book loaded successfully, Book details="+b);
		return b;
		
	}

  @SuppressWarnings("unchecked")
  @Override
  public List<Book> categoryBook(String name)
  {
    Session session = this.sessionFactory.getCurrentSession();
    List<Book> categoryList = session.createQuery("from Book where category='"+name+"'").list();
    for (Book b : categoryList) {
      System.out.println("Book List::" + b);
    }
    return categoryList;
  
  }

 

}
