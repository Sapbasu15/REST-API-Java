package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    static HashMap<Integer, Book> library = new HashMap<>();
    static int count = 0;

    static {
        library.put(1, new Book(1,"The Time Machine", "H.G.Wells", "Science Fiction"));
        library.put(2, new Book(2,"The Alchemist", "Paulo Coelho", "Drama"));
        library.put(3, new Book(3,"Think and Grow Rich", "Napoleon Hill", "Motivational"));
        count = 4;
    }

    public Book addBook(Book book){
        int newId = count++;
        book.setId(newId);
        library.put(newId, book);
        return book;
    }

    public Book getBookById(int id){
        return library.getOrDefault(id, null);
    }

    public ArrayList<Book> getAllBooks(){
        return new ArrayList<>(library.values());
    }

    public boolean updateBook(Book book){
        int id = book.getId();
        if (library.containsKey(id)){
            library.put(id, book);
            return  true;
        }
        return false;
    }

    public boolean deleteBook(int id){
        Book book = library.remove(id);
        return book != null;
    }
}
