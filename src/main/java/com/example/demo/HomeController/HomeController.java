package com.example.demo.HomeController;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private com.example.demo.Service.BookService BookService;

    @Autowired
    public HomeController (BookService bookService){
        this.BookService = bookService;
    }


    @GetMapping("/")
    public String index(Model model){

        List<Book> bookList = BookService.fetchAll();
        model.addAttribute ("books", bookList);
        return "home/index";
    }


    @GetMapping("/create")
    public String create(){
        return "home/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Book book){
        BookService.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/viewOne/{bookId}")
    public String viewOne(@PathVariable("bookId") int bookId, Model model){
        model.addAttribute("books", BookService.findBook(bookId));
        return "home/viewOne";
    }

    @GetMapping("/delete/{bookId}")
    public String deleteBook (@PathVariable("bookId") int bookId){
        boolean deleted = BookService.deleteBook(bookId);
        return "redirect:/";
    }

    @GetMapping("/update/{bookId}")
    public String update(@PathVariable("bookId") int bookId, Model model){
        model.addAttribute("book", BookService.findBook(bookId));
        return "home/update";
    }


    @PostMapping("/updateBook/{bookId}")
    public String updateBook(@ModelAttribute Book book, @PathVariable("bookId") int bookId){
        BookService.updateBook(book, bookId);
        return "redirect:/";
    }

    @GetMapping("/anyBooks/getAnyBooks")
    public String getAnyBooks(@ModelAttribute Book book, Model model) {
        List<Book> boo = BookService.findAnyBook(book.getAuthorFirstName());
        model.addAttribute("books", boo);
        return "home/anyBooks";
    }


}
