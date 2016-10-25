package com.ars.pro1.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ars.pro1.model.Book;
import com.ars.pro1.model.User;
import com.ars.pro1.service.BookService;

@Controller
public class Categories
{
  @Autowired
  private BookService bookService;

  @RequestMapping(value ="/literature",method = RequestMethod.GET )
  public String aliteraturepage(ModelMap  model,HttpSession session,String name)  {
    name="Literature";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listLiterature", category);
   // model.addAttribute("bookid",bookService.getBookById(id));
    return "literature";
  
  }
  
  @RequestMapping(value ="/comics",method = RequestMethod.GET)
  public String comicspage(ModelMap  model,HttpSession session, String name)  {
    name="Comics";
  
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listComics", category);
    return "comics";
  
  }
  
  @RequestMapping(value ="/history",method = RequestMethod.GET)
  public String historypage(ModelMap  model,HttpSession session,String name) 
  {
    name="History";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listHistory", category);
    return "history";
  
  }
  

  @RequestMapping(value ="/manga",method = RequestMethod.GET)
  public String manga(@ModelAttribute Book book,Model model,HttpSession session,String name) throws UnsupportedEncodingException {
    name="Manga";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listManga", category);

    return "manga";
  }
  

  @RequestMapping(value ="/sciencefiction",method = RequestMethod.GET)
  public String sciencefiction(Model model,HttpSession session,String name) {
    name="Science Fiction";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listScienceFiction", category);

    return "sciencefiction";
  }
  

  @RequestMapping(value ="/romance",method = RequestMethod.GET)
  public String romance(Model model,HttpSession session,String name){
    name="Romance";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listRomance", category);
    
    return "romance";
  }
  

  @RequestMapping(value ="/drama",method = RequestMethod.GET)
  public String drama(Model model,HttpSession session,String name) {
    name="Drama";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listDrama", category);
 
    return "drama";
  }
  

  @RequestMapping(value ="/philosophy",method = RequestMethod.GET)
  public String philosophy(Model model,HttpSession session,String name) {
    name="Philosophy";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listPhilosophy", category);
 
    return "philosophy";
  }
  

  @RequestMapping(value ="/fantasy",method = RequestMethod.GET)
  public String fantasy(Model model,HttpSession session,String name) {
    name="Fantasy";
    model.addAttribute("user", new User());
    session.getAttribute("userloggedin");
    model.addAttribute("book", new Book());
    
    List<Book> category=this.bookService.categoryBook(name);
    model.addAttribute("listFantasy", category);
   
    return "fantasy";
  }
  
}
