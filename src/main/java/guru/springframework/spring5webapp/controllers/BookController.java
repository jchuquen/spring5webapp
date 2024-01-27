package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // When there is any request to /books path run this method
    public String getBooks(Model model) { // We want to bring up the model to our controller
        // model is what is going to get returned. The view is going to get a copy of the model

        model.addAttribute("books", bookRepository.findAll()); // Add a new attribute to the model where to store our info
        return "books/list"; // Name of view that manage books rendering
    }
}
