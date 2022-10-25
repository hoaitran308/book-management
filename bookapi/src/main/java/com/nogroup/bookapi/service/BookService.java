package com.nogroup.bookapi.service;

import com.nogroup.bookapi.dto.BookResponse;
import com.nogroup.bookapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public List<BookResponse> getAll() {
    return bookRepository.findAll()
        .stream()
        .map(BookResponse::fromEntity)
        .collect(Collectors.toList());
  }

  public List<BookResponse> getAllByKeyword(String keyword) {
    return bookRepository.findAllByKeyword(keyword)
        .stream()
        .map(BookResponse::fromEntity)
        .collect(Collectors.toList());
  }

  public BookResponse getBook(Long id) {
    var optBook = bookRepository.findById(id);
    return optBook.map(BookResponse::fromEntity).orElse(null);
  }
}
