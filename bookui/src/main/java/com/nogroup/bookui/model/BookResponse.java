package com.nogroup.bookui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

  private Long id;
  private String title;
  private String desc;
  private String thumb;
  private LocalDate createdDate;
  private String author;
}
