package com.ars.pro1.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ars.pro1.dao.UserDao;
import com.ars.pro1.model.User;
import com.ars.pro1.service.UserService;

@Service
public class UserServiceImpl implements UserService
{

  @Autowired
  private UserDao userDao;
  
  @Override
  @Transactional
  public void adduser(User u)
  {
 this.userDao.adduser(u);
    
  }

  @Override
  @Transactional
  public void updateuser(User u)
  {
    this.userDao.updateuser(u);
    
  }

  @Override
  @Transactional
  public void deleteuser(int id)
  {
    this.userDao.deleteuser(id);
    
  }

  @Override
  @Transactional
  public List<User> listUser()
  {

    return this.userDao.listUser();
  }

  @Override
  @Transactional
  public User getUserById(int id)
  {

    return this.userDao.getUserById(id);
  }

  @Override
  public boolean isValidUser(String email, String password) throws SQLException
  {
  
    return userDao.isValidUser(email, password);
  }

}
