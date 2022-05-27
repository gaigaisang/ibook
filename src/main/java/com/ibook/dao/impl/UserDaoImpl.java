package com.ibook.dao.impl;

import com.ibook.bean.User;
import com.ibook.dao.UserDao;
import com.ibook.utils.DruidUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public int insUser(User user) {
        String sql = "INSERT INTO user(id,username,password,gender,email,telephone,introduce,activeCode,state,role) VALUES(?,?,?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, UUID.randomUUID().toString(), user.getUsername(), user.getPassword(), user.isGender(), user.getEmail(), user.getTelephone(), user.getIntroduce(), user.getActiveCode(), user.isState(), user.isRole());
        return update;
    }
    @Test
    public void test1() {
        User user = new User();
        user.setUsername("1");
        user.setPassword("1");
        user.setEmail("1");
        user.setTelephone("1");
        user.setIntroduce("1");
        user.setActiveCode("1");

        int i = insUser(user);
        System.out.println(i);
    }

    @Override
    public int delUser(String id) {
        String sql = "delete from user where id=?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public int updUser(String id, User user) {
        String sql = "update user set username=?,password=?,gender=?,email=?,telephone=?,introduce=?,activeCode=?,state=?,role=? where id = ?";
        int update = jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.isGender(),user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActiveCode(),user.isState(),user.isRole(),id);
        return update;
    }

    @Override
    public List<User> findUserById(String id) {
        String sql = "select * from user where id=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return list;
    }

    @Override
    public List<User> findUserByUsername(String username) {
        String sql = "select * from user where username=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), username);
        return list;
    }

    @Override
    public List<User> findUser(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        return list;
    }

    @Override
    public List<User> findUserByActiveCode(String activeCode) {
        String sql = "select * from user where activeCode=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), activeCode);
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Test
    public void test2() {
        List<User> list = findUserByUsername("2");
        for (User user : list) {
            System.out.println(user.isGender()+" "+user.isState()+" "+user.isRole()+" "+user.getRegistTime().getTime());
        }
    }
}
