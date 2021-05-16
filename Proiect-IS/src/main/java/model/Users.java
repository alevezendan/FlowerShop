package model;


//import lombok.Data;

import entity.User;

import java.util.List;

//@Data
public class Users {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
