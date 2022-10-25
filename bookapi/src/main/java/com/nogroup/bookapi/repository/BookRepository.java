package com.nogroup.bookapi.repository;

import com.nogroup.bookapi.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @Query(value = "SELECT book.*, author.name " +
      "FROM book " +
      "JOIN author ON book.author_id = author.id " +
      "WHERE book.title LIKE %:keyword% " +
      "OR author.name LIKE %:keyword%", nativeQuery = true)
  List<Book> findAllByKeyword(String keyword);
}
