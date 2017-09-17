/*
 * Copyright (c) 2017.  This is a piece of work done by Amrit S Dutta ,Bangalore, India.
 */

package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookListController {
    private BookListRepository readingListRepository;

    @Autowired
    public BookListController(BookListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Book> availableBooks() {
        List<Book> readingList = new ArrayList<>();
        readingList = readingListRepository.findAll();

        return readingList;
    }

    @RequestMapping(value = "/{bookname}", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> readersBooks(
            @PathVariable("bookname") String bookname) {
        List<Book> readingList =
                readingListRepository.findByBookName(bookname);

        return readingList;
    }
}
