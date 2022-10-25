package com.nogroup.bookapi.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "book")
public class Book {

  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private @Id Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String desc;

  @Column(name = "thumbnail")
  private String thumb;

  @Column(name = "created_date")
  private LocalDate createdDate;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  private Author author;
}
