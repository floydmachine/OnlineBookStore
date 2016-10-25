package com.ars.pro1.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ars.pro1.model.Book;
import com.ars.pro1.service.BookService;

@Controller
public class ImageController
{
  
  @Autowired
 private BookService bookService;

  
  
@RequestMapping(value = "/getImg{id}", method = RequestMethod.GET,
      produces = MediaType.IMAGE_JPEG_VALUE)
public ResponseEntity<byte[]> ListImage(@PathVariable int id) throws IOException{
  Book b = bookService.getBookById(id);
  byte [] image = b.getImage();
  final HttpHeaders headers = new HttpHeaders();
  headers.setContentType(MediaType.IMAGE_JPEG);
  return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
}
/*  @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
  public void showImage(@RequestParam("id") int id, HttpServletResponse response,HttpServletRequest request) 
          throws ServletException, IOException{


  // Item item = itemService.get(itemId);  
    Book book =bookService.getBookById(id); 
    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
    response.getOutputStream().write(book.getImage());


    response.getOutputStream().close();
  }*/

}
