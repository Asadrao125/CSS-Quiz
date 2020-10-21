package com.example.cssquiz;

public class UserModel {
    String current_id;
    String name;
    String email;
    String number;
    String password;

    public UserModel(String current_id, String name, String email, String number, String password) {
        this.current_id = current_id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    public UserModel() {
    }

    public String getCurrent_id() {
        return current_id;
    }

    public void setCurrent_id(String current_id) {
        this.current_id = current_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
