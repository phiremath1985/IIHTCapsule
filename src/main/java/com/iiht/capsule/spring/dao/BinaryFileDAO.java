package com.iiht.spring.dao;

import com.iiht.spring.entities.Book;
import com.iiht.spring.entities.Subject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class BinaryFileDAO {
    public void serializeDetails(List<Book> books, List<Subject> subjects) {
        try {
            FileOutputStream fos = new FileOutputStream("E:/IIHT_PROJECTS/Spring-Assignment/books.store");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
        } catch (IOException e) {
            System.err.println("Serialization Failed for Books!!");
        }

        try (FileOutputStream fos = new FileOutputStream("E:/IIHT_PROJECTS/Spring-Assignment/subjects.store"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(subjects);
        } catch (IOException e) {
            System.err.println("Serialization Failed for Subjects!!");
        }

    }

    public void deSerializeDetails(List<Book> books, List<Subject> subjects) {
        try (FileInputStream fis = new FileInputStream("E:/IIHT_PROJECTS/Spring-Assignment/books.store"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            books.addAll((List<Book>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No Serialized File Found for Books Initializing it to Empty");
        }

        try (FileInputStream fis = new FileInputStream("E:/IIHT_PROJECTS/Spring-Assignment/subjects.store"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            subjects.addAll((List<Subject>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No Serialized File Found for Subjects Initializing it to Empty");
        }
    }
}

