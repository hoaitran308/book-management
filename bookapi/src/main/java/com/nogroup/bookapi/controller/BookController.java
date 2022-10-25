package com.nogroup.bookapi.controller;

import com.nogroup.bookapi.dto.BookResponse;
import com.nogroup.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<BookResponse> getAll() {
    return bookService.getAll();
  }

  @GetMapping(path = "search")
  @ResponseStatus(HttpStatus.OK)
  public List<BookResponse> getAll(@RequestParam(name = "q") String keyword) {
    return bookService.getAllByKeyword(keyword);
  }

  @GetMapping(path = "{bookId}")
  @ResponseStatus(HttpStatus.OK)
  public BookResponse getBookById(@PathVariable Long bookId) {
    return bookService.getBook(bookId);
  }
}
