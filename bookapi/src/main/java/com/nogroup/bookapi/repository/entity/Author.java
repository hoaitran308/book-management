package com.nogroup.bookapi.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "day_of_birth")
  private LocalDate dayOfBirth;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private List<Book> employees;
}