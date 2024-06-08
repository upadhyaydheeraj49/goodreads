package com.example.goodreads;

public class Book {
    // temporary storage
    private int id;
    private String name;
    private String bookUrl;

    public Book(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.bookUrl = imageUrl;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.bookUrl;
    }

    public void setUrl(String url) {
        this.bookUrl = url;
    }

}