package com.ibook.dao.impl;

import com.ibook.bean.Category;
import com.ibook.dao.CategoryDao;
import com.ibook.utils.DruidUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class CategoryDaoImpl implements CategoryDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtil.getDataSource());

    @Override
    public int insCategory(Category category) {
        String sql = "insert into category(id,name,description) values(?,?,?)";
        int update = jdbcTemplate.update(sql, UUID.randomUUID().toString(), category.getName(), category.getDescription());
        return update;
    }

    @Override
    public int delCategory(String id) {
        String sql = "delete from category where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    @Override
    public int updCategory(String id, Category category) {
        String sql = "update category set name = ?,description = ? where id = ?";
        int update = jdbcTemplate.update(sql, category.getName(), category.getDescription(), id);
        return update;
    }

    @Override
    public List<Category> selAllCategory() {
        String sql = "select * from category";
        List<Category> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        return list;
    }
}
