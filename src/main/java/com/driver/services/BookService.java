package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.models.Genre;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;
    AuthorRepository authorRepository1;

    public void createBook(Book book){

        int authorId = book.getAuthor().getId();
        Author author = authorRepository1.findById(authorId).get();

        List<Book> bookList = author.getBooksWritten();
        bookList.add(book);
        author.setBooksWritten(bookList);

        book.setAuthor(author);
        book.setAvailable(true);
        authorRepository1.save(author);

       // bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = null; //find the elements of the list by yourself

        List<Book> bookList = bookRepository2.findAll();
        for(Book book : bookList){
            if(book.getGenre()!=null && book.isAvailable()==true)
                books.add(book);
            if(book.getGenre()!=null && book.isAvailable()==false && book.getAuthor()!=null)
                books.add(book);
        }
        return books;
    }
}
