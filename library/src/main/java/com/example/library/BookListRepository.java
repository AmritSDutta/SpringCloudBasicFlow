/*
 * Copyright (c) 2017.  This is a piece of work done by Amrit S Dutta ,Bangalore, India.
 */

package com.example.library;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookListRepository extends JpaRepository<Book, Long> {
    List<Book> findByBookName(String reader);
}
