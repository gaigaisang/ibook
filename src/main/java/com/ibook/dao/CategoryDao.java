package com.ibook.dao;

import com.ibook.bean.Category;

import java.util.List;

public interface CategoryDao {
    public int insCategory(Category category);
    public int delCategory(String id);
    public int updCategory(String id,Category category);
    public List<Category> selAllCategory();



}
