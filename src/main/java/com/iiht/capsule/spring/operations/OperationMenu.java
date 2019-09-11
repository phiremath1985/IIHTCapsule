package com.iiht.spring.operations;

import com.iiht.spring.dao.*;
import com.iiht.spring.dto.BookDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class OperationMenu {

    @Autowired
    OperationsImpl operations;

    @Autowired
    BinaryFileDAO binaryFileDAO;

    @Autowired
    BookDataDto bookDataDto;


    public void displayMenu() {


        binaryFileDAO.deSerializeDetails(bookDataDto.books, bookDataDto.subjects);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Subject");
            System.out.println("3. Delete a Subject");
            System.out.println("4. Delete a Book");
            System.out.println("5. Search for a Book");
            System.out.println("6. Search for a Subject");
            System.out.println("7. Sort Book by Title");
            System.out.println("8. Sort Subject by Title");
            System.out.println("9. Sort Book by Publish Date");
            System.out.println("10. Exit");
            System.out.print("Enter Your Option: ");

            Scanner s = new Scanner(System.in);
            int option = Integer.parseInt(s.nextLine());

            switch (option) {
                case 1:
                    operations.addBook();
                    break;
                case 2:
                    operations.addSubject();
                    break;
                case 3:
                    operations.deleteSubject();
                    break;
                case 4:
                    operations.deleteBook();
                    break;
                case 5:
                    operations.searchBook();
                    break;
                case 6:
                    operations.searchSubject();
                    break;
                case 7:
                    operations.sortBookByTitle();
                    break;
                case 8:
                    operations.sortSubjectByTitle();
                    break;
                case 9:
                    operations.sortBookByPublishDate();
                    break;
                case 10:
                    binaryFileDAO.serializeDetails(bookDataDto.books, bookDataDto.subjects);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option..");

            }
        }
    }
}
