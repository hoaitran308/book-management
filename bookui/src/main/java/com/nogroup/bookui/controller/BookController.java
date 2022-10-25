package com.nogroup.bookui.controller;

import com.nogroup.bookui.connector.BookApiConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@Validated
@RequestMapping
@RequiredArgsConstructor
public class BookController {

  private final BookApiConnector bookApiConnector;

  @GetMapping
  public String viewIndex(Model model) {
    var books = bookApiConnector.getAllBooks();
    model.addAttribute("books", books);
    return "index";
  }

  @GetMapping(path = "/search")
  public String viewSearch(Model model,
                           @RequestParam(name = "q") String keyword) {
    var books = bookApiConnector.getAllBooks(keyword);
    model.addAttribute("books", books);
    model.addAttribute("keyword", keyword);
    return "index";
  }

  @GetMapping(path = "/detail/{bookId}")
  public String viewDetail(Model model, @PathVariable Long bookId) {
    var book = bookApiConnector.getBook(bookId);

    if (Objects.isNull(book)) {
      return "redirect:/404";
    }

    model.addAttribute("book", book);
    return "detail";
  }

  @GetMapping(path = "/404")
  public String viewError() {
    return "404";
  }
}
