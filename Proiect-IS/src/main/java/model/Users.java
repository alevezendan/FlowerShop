package model;

import entity.User;
//import lombok.Data;

import java.util.ArrayList;

//@Data
public class Users {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
