package com.nogroup.bookapi.dto;

import com.nogroup.bookapi.repository.entity.Book;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookResponse {

  private Long id;
  private String title;
  private String desc;
  private String thumb;
  private LocalDate createdDate;
  private String author;

  public static BookResponse fromEntity(Book book) {
    return BookResponse.builder()
        .id(book.getId())
        .title(book.getTitle())
        .desc(book.getDesc())
        .thumb(book.getThumb())
        .createdDate(book.getCreatedDate())
        .author(book.getAuthor().getName())
        .build();
  }
}
