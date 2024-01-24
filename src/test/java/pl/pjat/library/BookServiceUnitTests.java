package pl.pjat.library;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTests {

    @Mock
    private BookStorage bookStorage;
    @InjectMocks
    private BookService bookService;


    @Test
    void addNewBook() {
        Book book = bookService.addNewBook("Kubus Puchatek", "Ktos tam", 1987, 001);
        Mockito.when(bookStorage.getBookList()).thenReturn(List.of(book));
        Assertions.assertNotNull(book);
        Assertions.assertEquals(1, bookStorage.getBookList().size());
    }


    @Test
    void BorrowBook() {
        User user = new User("Patryk", "Test", "PK1");
        Book book = bookService.addNewBook("Marvel", "Marvel", 1999, 002);
        Mockito.when(bookStorage.getBookList()).thenReturn(List.of(book));
        bookService.BorrowBook(user, 002);
        Assertions.assertTrue(book.isBorrowed());
        Assertions.assertEquals(user, book.getCurrentUser());
    }

    @Test
    void unBorrowBook() {
        Book book = bookService.addNewBook("Marvel", "Marvel", 1999, 002);
        book.setBorrowed(true);

        Mockito.when(bookStorage.getBookList()).thenReturn(List.of(book));

        bookService.unBorrowBook(002);
        Assertions.assertNull(book.getCurrentUser());
        Assertions.assertFalse(book.isBorrowed());
    }

    @Test
    void BookBorrowInfo() {
        Book book = bookService.addNewBook("Marvel", "Marvel", 1999, 002);
        Book book1 = bookService.addNewBook("Kubus Puchatek", "Ktos tam", 1987, 001);
        book.setBorrowed(true);

        Mockito.when(bookStorage.getBookList()).thenReturn(List.of(book, book1));

        Assertions.assertNotNull(bookService.getBookInfo(002));
        Assertions.assertNull(bookService.getBookInfo(001));
    }

    @Test
    void getBorrowedBooksList() {
        Book book = bookService.addNewBook("Marvel", "Marvel", 1999, 002);
        Book book1 = bookService.addNewBook("Kubus Puchatek", "Ktos tam", 1987, 001);
        User user = new User("Patryk", "Test", "PK1");
        User user1 = new User("Kuba", "R", "KR1");
        book.setBorrowed(true);
        book.setCurrentUser(user);

        Mockito.when(bookStorage.getBookList()).thenReturn(List.of(book, book1));

        List<Book> books = bookService.getBorrowedBooksList(user);
        Assertions.assertTrue(books.contains(book));
        Assertions.assertFalse(books.contains(book1));
        Assertions.assertEquals(1, books.size());
        Assertions.assertFalse(books.isEmpty());
    }


}
