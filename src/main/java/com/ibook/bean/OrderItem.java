package com.ibook.bean;

public class OrderItem {
    private String id;
    private Book book;
    private int num;
    private double price;

    public OrderItem() {
    }

    public OrderItem(String id, Book book, int num, double price) {
        this.id = id;
        this.book = book;
        this.num = num;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
