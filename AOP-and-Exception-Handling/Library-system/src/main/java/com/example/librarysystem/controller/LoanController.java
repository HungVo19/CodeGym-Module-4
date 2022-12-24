package com.example.librarysystem.controller;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.model.Loan;
import com.example.librarysystem.service.IBookService;
import com.example.librarysystem.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    IBookService bookService;
    @Autowired
    ILoanService loanService;

    @GetMapping("/list")
    public ModelAndView showList() {
        return new ModelAndView("index", "books", bookService.findAll());
    }


    @GetMapping("/showBorrowForm/{bookId}")
    public ModelAndView showBorrowForm(@PathVariable Long bookId) {
        Optional<Book> book = bookService.findById(bookId);
        ModelAndView modelAndView = new ModelAndView("borrowForm");
        if (book.isPresent()) {
            modelAndView.addObject("book", book.get());
        } else {
            return new ModelAndView("error");
        }
        return modelAndView;
    }

    @PostMapping("/borrow")
    public ModelAndView borrow(@ModelAttribute(name = "book") Book book, RedirectAttributes redirectAttributes) {
        if (book.getCopies() == 0) {
            return new ModelAndView("error");
        } else {
            String code = "#" + LocalDateTime.now();
            Loan loan = new Loan(code, book);

            loanService.save(loan);

            book.setCopies(book.getCopies() - 1);
            bookService.save(book);

            redirectAttributes.addFlashAttribute("message", "Your borrow code is " + code);

            return new ModelAndView("redirect:/loans/list");
        }
    }

    @GetMapping("/showReturnForm")
    public ModelAndView returnForm() {
        return new ModelAndView("return");
    }

    @PostMapping("/return")
    public ModelAndView returnBook(@RequestParam(name = "code") String code,
                                   RedirectAttributes redirectAttributes) throws Exception
    {
        try {
            Book book = loanService.findBookByCode(code);
            loanService.removeByCode(code);
            book.setCopies(book.getCopies() + 1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("message", "Return successfully !");
            return new ModelAndView("redirect:/loans/list");
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }
}
