 package com.ars.pro1.controller;

 import java.io.IOException;
 import java.util.List;

 import javax.servlet.http.HttpSession;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.multipart.MultipartFile;

 import com.ars.pro1.model.Book;
 import com.ars.pro1.service.BookService;

 @Controller
public class BookController
 {
  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/crudpage", method = RequestMethod.GET)
  public String listBooks1(Model model, HttpSession session)
  {
  //LoginAdmin loginAdmin = new LoginAdmin();
  session.getAttribute("adminloggedin");

model.addAttribute("book", new Book());
List<Book> list = this.bookService.listBook();
model.addAttribute("listBooks", list);
return "crudpage";
}

@RequestMapping(value = "/addbook", method = RequestMethod.POST)
public String addBook(@ModelAttribute("book") Book b, HttpSession  session, @RequestParam("file") MultipartFile fileUpload,Model model) throws IOException
 {
System.out.println("inside addbook");
session.getAttribute("adminloggedin");
//Book book = new Book();
if (fileUpload != null)
{

  b.setImage(fileUpload.getBytes());

  if (b.getId() == 0)
  {

    bookService.addbook(b);
  }
  else
  {
    bookService.updatebook(b);
  }
}

   return "redirect:/crudpage";

   }

         @RequestMapping("/removebook/{id}")
  public String removeBook(@PathVariable("id") int id, HttpSession session)
  {

session.getAttribute("adminloggedin");
this.bookService.removebook(id);
return "redirect:/crudpage";
}

 @RequestMapping("/editbook/{id}")
 public String editBook(@PathVariable("id") int id, Model model, HttpSession session)
  {
  session.getAttribute("adminloggedin");

model.addAttribute("book", bookService.getBookById(id));
model.addAttribute("listBooks", bookService.listBook());
return "crudpage";
 }

@RequestMapping(value = "/buy", method = RequestMethod.GET)
 public String buy(Model model, HttpSession session, @RequestParam String id)
 {
session.getAttribute("username");

Book book = new Book();
// model.addAttribute("book", book);
book = bookService.getBookById(Integer.parseInt(id));
book.setName(book.getName());
book.setAuthor(book.getAuthor());
book.setCategory(book.getCategory());
book.setPrice(book.getPrice());
book.setQuantity(book.getQuantity() - 1);
book.setImage(book.getImage());
bookService.updatebook(book);
model.addAttribute("listBooks", bookService.listBook());

return "home";

 }
  }