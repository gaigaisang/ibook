package com.ibook.service;

import com.ibook.bean.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public List<User> findUserByUsername(String username);
    public User findUser(String username,String password);
    public User findUserById(String id);
    public boolean activateUser(String activeCode);
}
