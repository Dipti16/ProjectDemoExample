package com.example.ProjectDemoExample.Controller;

import com.example.ProjectDemoExample.Dao.BookRepo;
import com.example.ProjectDemoExample.Entity.Book;
import com.example.ProjectDemoExample.service.FileUploader;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    BookRepo bookRepo;

    @Autowired
    FileUploader fileUploader;

    @GetMapping("/")
    public String home()
    {
        return "index";
    }

    @GetMapping("/book_register/")
    public String show() {

        return "bookReg";
    }

    @GetMapping("/available_book/")
    public String getAllBooks(Model model, Book book)
    {
        List <Book> booklist=bookRepo.findAll();
        model.addAttribute("booklist",booklist);
        return "bookList";
    }

    @PostMapping("/save/")
    public String save(Model model, Book book, MultipartFile file)
    {
         bookRepo.save(book);
        String fileNameOld=file.getOriginalFilename();
        String extension=fileNameOld.substring(fileNameOld.indexOf("."));
        book.setExt(extension);
        Book bk=bookRepo.save(book);
        String fileNameNew=bk.getId()+"."+extension;
        fileUploader.uploadFile(file,fileNameNew);
        model.addAttribute("msg","Registration sucessfull");
        List <Book> booklist=bookRepo.findAll();
        model.addAttribute("booklist",booklist);
        return "bookList";

    }
    @GetMapping("/save/delete/{bookId}/")
    public String delete(Model model, @PathVariable long bookId)
    {
        bookRepo.deleteById(bookId);
        List <Book> booklist=bookRepo.findAll();
        model.addAttribute("booklist",booklist);
        return "bookList";
    }



}
