package com.ibook.dao.impl;

import com.ibook.bean.User;
import com.ibook.dao.UserDao;
import com.ibook.utils.DruidUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public int insUser(User user) {
        String sql = "INSERT INTO user(username,password,gender,email,telephone,introduce,activeCode,state,role) VALUES(?,?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.isGender(), user.getEmail(), user.getTelephone(), user.getIntroduce(), user.getActiveCode(), user.isState(), user.isRole());
        return update;
    }

    @Test
    public void test1() {
        User user = new User();
        user.setUsername("1");
        user.setPassword("1");
        user.setGender(true);
        user.setEmail("1");
        user.setTelephone("1");
        user.setIntroduce("1");
        user.setActiveCode("1");
        user.setState(true);
        user.setRole(false);
        int i = insUser(user);
        System.out.println(i);
    }

    @Override
    public int delUser(int id) {
        String sql = "delete from user where id=?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public int updUser(int id, User user) {
        String sql = "update user set username=?,password=?,gender=?,email=?,telephone=?,introduce=?,activeCode=?,state=?,role=? where id = ?";
        int update = jdbcTemplate.update(sql,user.getUsername(),user.getPassword(),user.isGender(),user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActiveCode(),user.isState(),user.isRole(),id);
        return update;
    }

    @Override
    public List<User> findUserById(int id) {
        String sql = "select * from user where id=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return list;
    }
    @Test
    public void test2() {
        List<User> list = findUserById(1);
        for (User user : list) {
            System.out.println(user.isGender()+" "+user.isState()+" "+user.isRole());
        }
    }
}
