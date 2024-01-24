package pl.pjat.library;

public class User {

    private String name;
    private String surname;
    private String userID;

    public User(String name, String surname, String userID) {
        this.name = name;
        this.surname = surname;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUserID() {
        return userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
