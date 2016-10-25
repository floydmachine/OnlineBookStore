package com.ars.pro1.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ars.pro1.dao.UserDao;
import com.ars.pro1.model.User;
@Repository
public class UserDaoImpl implements UserDao
{
  
private static final Logger logger=LoggerFactory.getLogger(UserDaoImpl.class);
@Autowired
private SessionFactory sessionFactory;
@Autowired
DataSource dataSource;

  @Override
  public void adduser(User u)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.persist(u);
    logger.info("User added succsfully"+u);
  }

  @Override
  public void updateuser(User u)
  {
  Session session=this.sessionFactory.getCurrentSession();
  session.update(u);
  logger.info("User updated succesfully"+u);
    
  }

  @Override
  public void deleteuser(int id)
  {
   Session session=this.sessionFactory.getCurrentSession();
   User u=(User) session.load(User.class,new Integer(id));
   if(null!=u){
   session.delete(u);
   }
   logger.info("User Deleted Succesfully"+u);
  }
  @SuppressWarnings("unchecked")
  @Override
  public List<User> listUser()
  {
    Session session=this.sessionFactory.getCurrentSession();
    List<User> usersList= session.createQuery("from User").list();
    for(User u:usersList){
      System.out.println("Users List::" +u);
    }
    return usersList;
  }

  @Override
  public User getUserById(int id)
  {
    Session session= this.sessionFactory.getCurrentSession();
    User u= (User) session.load(User.class, new Integer(id));
    logger.info("User loaded succesfully"+u);
    return u;
  }

  @Override
  public boolean isValidUser(String email, String password) throws SQLException
  {
    String query = "Select count(1) from User where email = ? and password = ?";
    PreparedStatement pstmt = dataSource.getConnection().prepareStatement (query);
    pstmt.setString(1, email);
    pstmt.setString(2, password);
    ResultSet resultSet = pstmt.executeQuery();
    if (resultSet.next())
      return (resultSet.getInt(1) > 0);
    else
      return false;
    
  }

}
