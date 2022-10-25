package com.nogroup.bookui.connector;

import com.nogroup.bookui.model.BookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "book-api", url = "${feign.client.config.book-api.url}", path = "api/v1/books")
public interface BookApiConnector {

  @GetMapping
  List<BookResponse> getAllBooks();

  @GetMapping(path = "search")
  List<BookResponse> getAllBooks(@RequestParam(name = "q") String keyword);

  @GetMapping(path = "{bookId}")
  BookResponse getBook(@PathVariable Long bookId);
}