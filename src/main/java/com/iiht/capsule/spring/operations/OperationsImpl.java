package com.iiht.spring.operations;

import com.iiht.spring.dto.BookDataDto;
import com.iiht.spring.entities.Book;
import com.iiht.spring.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class OperationsImpl {

    @Autowired
    BookDataDto dataDto;

    public void addBook() {
        Scanner s = new Scanner(System.in);
        Book b = new Book();

        System.out.println("Add Book: Enter Below details");
        System.out.print("Book ID: ");

        long bookId = Long.parseLong(s.nextLine());
        b.setBookId(bookId);

        if (dataDto.books.contains(b)) {
            System.err.println("Book Already Exist, Book ID: " + bookId);
            return;
        }

        System.out.print("Title: ");
        String bookTitle = s.nextLine();
        b.setTitle(bookTitle);

        System.out.print("Price: ");
        double bookPrice = Double.parseDouble(s.nextLine());
        b.setPrice(bookPrice);

        System.out.print("Volume: ");
        Integer bookVolume = Integer.parseInt(s.nextLine());
        b.setVolume(bookVolume);


        System.out.print("Publish Date (yyyy-mm-dd): ");
        String publishDate = s.nextLine();
        b.setPublishDate(LocalDate.parse(publishDate));

        dataDto.books.add(b);
        System.out.println("Book Added Successfully, Book ID: " + bookId);
    }

    public void deleteBook() {
        Scanner s = new Scanner(System.in);

        System.out.println("Delete Book: Enter below details");
        System.out.print("Enter Book ID: ");
        Book b = new Book();
        long bookId = Long.parseLong(s.nextLine());
        b.setBookId(bookId);

        if (dataDto.books.contains(b)) {
            dataDto.books.remove(dataDto.books.indexOf(b));
            System.out.println("Book Deleted, Book ID : " + bookId);
        } else {
            System.out.println("Sorry!! Book Not Found");
        }

    }

    public void addSubject() {
        Scanner s = new Scanner(System.in);
        Subject sub = new Subject();

        System.out.println("Add Subject: Enter Below details");
        System.out.print("Subject ID: ");

        long subjectId = Long.parseLong(s.nextLine());
        sub.setSubjectId(subjectId);

        if (dataDto.subjects.contains(sub)) {
            System.err.println("Subject Already Exist, Subject ID: " + subjectId);
            return;
        }

        System.out.print("Subject Title: ");
        String subjectTitle = s.nextLine();
        sub.setSubtitle(subjectTitle);

        System.out.print("Duration in Hours: ");
        int durationInHours = Integer.parseInt(s.nextLine());
        sub.setDurationInHours(durationInHours);

        System.out.print("Add References: ");
        List<Integer> referenceBooks = Arrays.asList(s.nextLine().split(",")).stream().map(e -> Integer.parseInt(e.trim())).collect(Collectors.toList());

        referenceBooks.stream().forEach(referenceBook -> {
            Book b = new Book();
            b.setBookId(referenceBook);
            if (dataDto.books.contains(b))
                sub.getReferences().add(dataDto.books.get(dataDto.books.indexOf(b)));
            else
                System.out.println("Book Not Found, Book ID :" + referenceBook);
        });

        dataDto.subjects.add(sub);

        System.out.println("Subject Added Successfully, Subject ID: " + subjectId);
    }

    public void deleteSubject() {
        Scanner s = new Scanner(System.in);

        System.out.println("Delete Subject: Enter below details");
        System.out.print("Enter Subject ID: ");
        Subject sub = new Subject();
        long subjectId = Long.parseLong(s.nextLine());
        sub.setSubjectId(subjectId);

        if (dataDto.subjects.contains(sub)) {
            dataDto.subjects.remove(dataDto.subjects.indexOf(sub));
            System.out.println("Subject Deleted, Subject ID : " + subjectId);
        } else {
            System.out.println("Sorry!! Subject Not Found");
        }
    }

    public void searchBook() {
        Scanner s = new Scanner(System.in);

        System.out.println("Search Book: Enter below details");
        System.out.print("Enter Book ID: ");
        Book b = new Book();
        long bookId = Long.parseLong(s.nextLine());
        b.setBookId(bookId);

        if (dataDto.books.contains(b)) {
            System.out.println("Book Found, Details : " + dataDto.books.get(dataDto.books.indexOf(b)));
        } else {
            System.out.println("Sorry!! Book Not Found");
        }

    }

    public void searchSubject() {
        Scanner s = new Scanner(System.in);

        System.out.println("Search Subject: Enter below details");
        System.out.print("Enter Subject ID: ");
        Subject sub = new Subject();
        long subjectId = Long.parseLong(s.nextLine());
        sub.setSubjectId(subjectId);

        if (dataDto.subjects.contains(sub)) {
            System.out.println("Subject Found, Details : " + dataDto.subjects.get(dataDto.subjects.indexOf(sub)));
        } else {
            System.out.println("Sorry!! Subject Not Found");
        }
    }

    public void sortBookByTitle() {
        dataDto.books.stream().sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println);
    }

    public void sortSubjectByTitle() {
        dataDto.subjects.stream().sorted(Comparator.comparing(Subject::getSubtitle)).forEach(System.out::println);
    }

    public void sortBookByPublishDate() {
        dataDto.books.stream().sorted(Comparator.comparing(Book::getPublishDate)).forEach(System.out::println);
    }
}
