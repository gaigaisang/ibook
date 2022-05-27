package com.ibook.bean;

import java.util.List;

public class Cart {
    private List<Book> books;
    private double price;

    public Cart() {
    }

    public Cart(List<Book> books, double price) {
        this.books = books;
        this.price = price;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "books=" + books +
                ", price=" + price +
                '}';
    }
}
