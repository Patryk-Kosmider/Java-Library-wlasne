package pl.pjat.library;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class BookServiceITTests {

    private User user;
    private Book book;

    @Autowired
    private BookService bookService;
    @Autowired
    private BookStorage bookStorage;

    @Test
    void shouldCreateNewBook() {
        book = bookService.addNewBook("Kubus", "Puchatek", 1981, 001);
        Assertions.assertEquals(1, bookStorage.getBookList().size());
        Assertions.assertTrue(bookStorage.getBookList().contains(book));
    }

    @Test
    void BorrowBook() {
        user = new User("Patryk", "K", "PK1");
        bookService.BorrowBook(user, 001);
        Assertions.assertEquals(user, bookStorage.getBookList().get(0).getCurrentUser());
        Assertions.assertTrue(bookStorage.getBookList().get(0).isBorrowed());
    }

    @Test
    void unBorrowBook() {
        bookService.unBorrowBook(001);
        Assertions.assertNull(bookStorage.getBookList().get(1).getCurrentUser());
        Assertions.assertFalse(bookStorage.getBookList().get(1).isBorrowed());
    }

    @Test
    void getBookInfo() {
        Book book1 = bookService.addNewBook("Marvel", "bohater", 1988, 002);
        BorrowInfo borrowInfo = bookService.getBookInfo(001);
        BorrowInfo borrowInfo1 = bookService.getBookInfo(002);

        Assertions.assertTrue(borrowInfo.isBorrowed());
        Assertions.assertEquals(bookStorage.getBookList().get(0), borrowInfo.getBook());
        Assertions.assertEquals(bookStorage.getBookList().get(0).getCurrentUser(), borrowInfo.getUser());
        Assertions.assertEquals(bookStorage.getBookList().get(1), borrowInfo1.getBook());
        Assertions.assertFalse(borrowInfo1.isBorrowed());
        Assertions.assertNull(borrowInfo1.getUser());
    }

    @Test
    void getBorrowedBooksList() {
        User user2 = new User("Kuba","R", "KR1");
        user = new User("Patryk", "K", "PK1");
        bookService.BorrowBook(user, 001);
        List<Book> booksTrue = bookService.getBorrowedBooksList(user);
        List<Book> booksFalse = bookService.getBorrowedBooksList(user2);

        Assertions.assertEquals(1, booksTrue.size());
        Assertions.assertTrue(booksTrue.contains(bookStorage.getBookList().get(0)));
        Assertions.assertTrue(booksFalse.isEmpty());

    }
}
