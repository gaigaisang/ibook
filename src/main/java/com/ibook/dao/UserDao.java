package com.ibook.dao;

import com.ibook.bean.User;

import java.util.List;

public interface UserDao {
//    public User findUserByUsername(String username);
    public int insUser(User user);
    public int delUser(int id);
    public int updUser(int id ,User user);
//    public int updUser(int id, User user);
//    public int updUser(String username, User user);
     public List<User> findUserById(int id);
}
