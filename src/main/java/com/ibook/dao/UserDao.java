package com.ibook.dao;

import com.ibook.bean.User;

import java.util.List;

public interface UserDao {
    public int insUser(User user);

    public int delUser(String id);

    public int updUser(String id, User user);

    public List<User> findUserById(String id);

    public List<User> findUserByUsername(String username);

    public List<User> findUser(String username,String password);

    public List<User> findUserByActiveCode(String activeCode);
}
