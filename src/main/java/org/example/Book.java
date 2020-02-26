package org.example;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Book(int i, String t, String a, String g){
        id = i;
        title = t;
        author = a;
        genre = g;
    }

    public Book(){}

    @Override
    public String toString(){
        return  String.format("ID: %d, Title: %s, Author: %s, Genre: %s",id, title, author, genre);
    }
}
