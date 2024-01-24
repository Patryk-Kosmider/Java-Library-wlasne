package pl.pjat.library;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookStorage {

    private final List<Book> bookList;

    public BookStorage(List<Book> bookList) {
        this.bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book){
        this.bookList.add(book);
    }
}
