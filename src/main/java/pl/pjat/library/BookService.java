package pl.pjat.library;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class BookService {

    private BookStorage bookStorage;

    public BookService(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public Book addNewBook(String title, String author, int yearOfPremiere, int bookId){
        Book newBook = new Book(title, author, yearOfPremiere, bookId);
        bookStorage.addBook(newBook);
        return newBook;
    }

    public void BorrowBook(User user, int bookId){
        for (Book book : bookStorage.getBookList()){
            if(book.getBookId() == bookId){
                book.setBorrowed(true);
                book.setCurrentUser(user);
            }
        }
    }

    public void unBorrowBook(int bookId){
        for (Book book: bookStorage.getBookList()){
            if (book.getBookId() == bookId){
                if (book.isBorrowed()){
                    book.setBorrowed(false);
                    book.setCurrentUser(null);
                } else {
                    throw new RuntimeException("This book isn't borrowed");
                }
            }
        }
    }

    public BorrowInfo getBookInfo(int bookId){
        Book foundBook = null;
        for(Book book: bookStorage.getBookList()){
            if(book.getBookId() == bookId){
                foundBook = book;
                if(foundBook.isBorrowed()){
                    return new BorrowInfo(book, book.getCurrentUser(), book.isBorrowed());
                    }
                }
            }
        return new BorrowInfo(foundBook, null, false);
        }

    public List<Book> getBorrowedBooksList(User user){
        ArrayList<Book> bookArrayList = new ArrayList<>();
        for(Book book: bookStorage.getBookList()){
            if(book.getCurrentUser() != null){
                if (book.getCurrentUser().equals(user)) {
                    bookArrayList.add(book);
                }
            }
        }
        return bookArrayList;
    }

}
