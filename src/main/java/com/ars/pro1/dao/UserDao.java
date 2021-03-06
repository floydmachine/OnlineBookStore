package com.ars.pro1.dao;



import java.sql.SQLException;
import java.util.List;

import com.ars.pro1.model.User;

public interface UserDao
{
  public void adduser(User u);
  
  public void updateuser(User u);
  
  public void deleteuser(int id);
  
  public List<User> listUser();
  
  public User getUserById(int id);
  
  public boolean isValidUser(String email, String password)
      throws SQLException;
  

}
