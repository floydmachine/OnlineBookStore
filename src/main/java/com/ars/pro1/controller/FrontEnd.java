package com.ars.pro1.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ars.pro1.model.Book;
import com.ars.pro1.model.User;
import com.ars.pro1.service.BookService;
import com.ars.pro1.service.UserService;
@Controller

public class FrontEnd
{
  @Autowired
  private UserService userService;
  
  @Autowired
  private BookService bookService;
  
  @RequestMapping(value ="/home",method = RequestMethod.GET)
  public String ahomepage(@ModelAttribute Book book,ModelMap  model,HttpSession session) throws UnsupportedEncodingException  {
  
  
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    
    List<Book> list = this.bookService.listBook();
    model.addAttribute("listBooks", list);
/*    byte[] encodeBase64=Base64.encodeBase64(book.getBookimage());
    String base64Encoded=new String(encodeBase64,"UTF-8");
    model.addAttribute("bookimage", base64Encoded);
 */
    /*byte[] encodeBase64 = Base64.encode(bookService.listBook());
    String base64Encoded = new String(encodeBase64, "UTF-8");
     model.addAttribute("userImage", base64Encoded);*/
 return "home";
  
  }
  
 
 
     
  
  @RequestMapping(value ="/signup",method = RequestMethod.GET)
  public String signup(Model model) {
  User user=new User();
 model.addAttribute("user", user);

    return "signup";
  }
    @RequestMapping(value ="/signup",method = RequestMethod.POST)
    public String SignUp( @Valid User user, BindingResult result,Model model) {
   
          
      if (result.hasErrors()) {
  

        return "signup";
    }
      model.addAttribute("user", user);

  
    this.userService.adduser(user);
    return "home";
    }
    

    @RequestMapping(value ="/start",method = RequestMethod.GET)
    public String startpage()  {
    
    
          return "start";
    
    }    
 
  
}
