package com.ars.pro1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ars.pro1.model.LoginAdmin;
import com.ars.pro1.model.User;
import com.ars.pro1.service.UserService;

@Controller

public class UserController
{
  @Autowired
private UserService userService;
  

  @RequestMapping(value ="/usercrud", method = RequestMethod.GET)
  public String listBooks1(Model model,HttpSession session) {
    session.getAttribute("adminloggedin");
    model.addAttribute("loginAdmin", new LoginAdmin());
    model.addAttribute("user", new User());
    List<User> list = this.userService.listUser();
    model.addAttribute("listUsers", list);
    return "usercrud";
  }
  
  @RequestMapping(value ="/usercrud/adduser", method = RequestMethod.POST)
  public String addUser(User u,Model model,HttpSession session) {
    session.getAttribute("userloggedin");
    model.addAttribute("loginAdmin", new LoginAdmin());

    if (u.getId() == 0) {
      userService.adduser(u);
    } 
    else {
    userService.updateuser(u);
    }

    return "redirect:/usercrud";

  }
  @RequestMapping("/removeuser/{id}")
  public String removeUser(@PathVariable("id") int id,Model model,HttpSession session) {
    //LoginAdmin loginmodel=new LoginModel();
    session.getAttribute("adminloggedin");
    //model.addAttribute("loginAdmin", new LoginAdmin());

    this.userService.deleteuser(id);
    return "redirect:/usercrud";
  }

  @RequestMapping("/edituser/{id}")
  public String editUser(@PathVariable("id") int id, Model model,HttpSession session) {
    // ModelAndView obj=new ModelAndView("person");
    // obj.addObject("aaa", this.personService.getPersonById(id));
    session.getAttribute("adminloggedin");
    model.addAttribute("user", new User());
    model.addAttribute("user", this.userService.getUserById(id));
    model.addAttribute("listUsers", this.userService.listUser());
    return "usercrud";
  }
  


}

