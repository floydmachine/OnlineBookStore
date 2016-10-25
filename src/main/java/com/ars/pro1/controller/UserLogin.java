package com.ars.pro1.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ars.pro1.model.User;
import com.ars.pro1.service.UserService;

@Controller

public class UserLogin
{
  
  @Autowired
  
  private UserService userService;
 
  
  
  @RequestMapping(value="/userlogin", method=RequestMethod.GET)
  public String userloginpage(Model model){
    model.addAttribute("user", new User());
    
    return "userlogin";
    
  }
  
  
  @RequestMapping(value="/userlogin", method=RequestMethod.POST)
  public String userlogincomplete( @ModelAttribute User userlogin, ModelMap model, HttpSession session,BindingResult result) throws SQLException{
    
if (result.hasErrors()) {

  return "userlogin";
}
    boolean userexist=userService.isValidUser(userlogin.getEmail(), userlogin.getPassword());
    if(userexist==true){
    session.setAttribute("userloggedin", userlogin);
    return "redirect:/home";
    }
    else{
      model.put("error", "Invalid Account");
    return "userlogin";
    }
    
    
  }
  

  
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpSession session, Model model) {
    session.removeAttribute("userloggedin");
    

    return "redirect:/userlogin";

  }   
  
  @RequestMapping("/myprofile/{id}")
  public String UserProfile(@PathVariable("id") int id, Model model,HttpSession session) {

  session.getAttribute("userloggedin");
  model.addAttribute("user", new User());
   //model.addAttribute("userlogin",userlogin);
    model.addAttribute("userid", this.userService.getUserById(id));
    model.addAttribute("listUsers", this.userService.listUser());
    return "crudpage";
  }

}
  
 