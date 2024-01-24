package pl.pjat.library;

public class Book {

    private String title;
    private boolean isBorrowed;
    private String author;
    private int yearOfPremiere;
    private User currentUser;

    private int bookId;
    public Book(String title, String author, int yearOfPremiere, int bookId) {
        this.title = title;
        this.isBorrowed = false;
        this.author = author;
        this.yearOfPremiere = yearOfPremiere;
        this.currentUser = null;
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPremiere() {
        return yearOfPremiere;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public int getBookId() {
        return bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPremiere(int yearOfPremiere) {
        this.yearOfPremiere = yearOfPremiere;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
