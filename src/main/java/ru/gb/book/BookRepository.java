package ru.gb.book;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
}