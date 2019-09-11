package com.iiht.spring.dto;

import com.iiht.spring.entities.Book;
import com.iiht.spring.entities.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDataDto {

    public List<Book> books = new ArrayList<Book>();
    public List<Subject> subjects = new ArrayList<Subject>();

}
