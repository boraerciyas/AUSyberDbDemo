package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty userName;
    private SimpleStringProperty userSurname;
    private SimpleStringProperty userInterest;
    private SimpleIntegerProperty userId;
    private SimpleStringProperty roleName;
    private SimpleStringProperty userEmail;

    public User(String userName, String userSurname, String userInterest, int userId, String roleName) {
        this.userName = new SimpleStringProperty(userName);
        this.userSurname = new SimpleStringProperty(userSurname);
        this.userId = new SimpleIntegerProperty(userId);
        this.roleName = new SimpleStringProperty(roleName);
        this.userInterest = new SimpleStringProperty(userInterest);
    }

    public User(String userName, String userSurname,String userEmail , String roleName, String userInterest)  {
        this.userName = new SimpleStringProperty(userName);
        this.userSurname = new SimpleStringProperty(userSurname);
        this.userEmail = new SimpleStringProperty(userEmail);
        this.roleName = new SimpleStringProperty(roleName);
        this.userInterest = new SimpleStringProperty(userInterest);
    }

    public User(SimpleStringProperty userName, SimpleStringProperty userSurname, SimpleStringProperty userInterest, SimpleIntegerProperty userId, SimpleStringProperty roleName, SimpleStringProperty userEmail) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userInterest = userInterest;
        this.userId = userId;
        this.roleName = roleName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getUserSurname() {
        return userSurname.get();
    }

    public SimpleStringProperty userSurnameProperty() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname.set(userSurname);
    }

    public String getUserInterest() {
        return userInterest.get();
    }

    public SimpleStringProperty userInterestProperty() {
        return userInterest;
    }

    public void setUserInterest(String userInterest) {
        this.userInterest.set(userInterest);
    }

    public int getUserId() {
        return userId.get();
    }

    public SimpleIntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public String getRoleName() {
        String role;
        switch (roleName.get())   {
            case "1":   role = "admin"; break;
            case "2":   role = "moderator"; break;
            case "3":   role = "user"; break;
            default:    role = "guest"; break;
        }
        return role;
    }

    public SimpleStringProperty roleNameProperty() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName.set(roleName);
    }

    public String getUserEmail() {
        return userEmail.get();
    }

    public SimpleStringProperty userEmailProperty() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail.set(userEmail);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName=" + userName +
                ", userSurname=" + userSurname +
                ", userInterest=" + userInterest +
                ", userId=" + userId +
                ", roleName=" + roleName +
                ", userEmail=" + userEmail +
                '}';
    }
}
