package com.ibook.service.impl;

import com.ibook.bean.User;
import com.ibook.dao.impl.UserDaoImpl;
import com.ibook.service.UserService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public boolean addUser(User user) {
        int i = userDaoImpl.insUser(user);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> findUserByUsername(String username) {
        List<User> users = userDaoImpl.findUserByUsername(username);
        if (users.size() > 0) {
            return users;
        }
        return null;
    }

    @Override
    public User findUser(String username, String password) {
        List<User> users = userDaoImpl.findUser(username, password);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public User findUserById(String id) {
        List<User> users = userDaoImpl.findUserById(id);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean activateUser(String activeCode) {
        List<User> users = userDaoImpl.findUserByActiveCode(activeCode);
        if (users.size() > 0) {
            User user = users.get(0);
            if (!user.isState()&&new Date().getTime()-user.getRegistTime().getTime()<=1000*60*20) {
                user.setState(true);
                int i = userDaoImpl.updUser(user.getId(),user);
                if (i > 0) {
                    return true;
                }
            }
        }
        return false;
    }
    @Test
    public void test(){
        List<User> userById = userDaoImpl.findUserById("20");
        System.out.println(userById.get(0).getRegistTime().getTime());
        System.out.println(new Date().getTime());
        long l = userById.get(0).getRegistTime().getTime() - new Date().getTime();
        System.out.println(l);
    }

}
