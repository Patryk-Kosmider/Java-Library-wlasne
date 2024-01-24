package pl.pjat.library;

public class BorrowInfo {

    private Book book;
    private User user;
    private boolean isBorrowed;


    public BorrowInfo(Book book) {
        this.book = book;
        this.user = null;
        this.isBorrowed = false;
    }

    public BorrowInfo(Book book, User user, boolean isBorrowed) {
        this.book = book;
        this.user = user;
        this.isBorrowed = isBorrowed;
    }


    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
