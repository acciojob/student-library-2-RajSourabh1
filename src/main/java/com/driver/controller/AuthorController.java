package com.driver.controller;

import com.driver.models.Author;
import com.driver.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//Add required annotations
@RestController
public class AuthorController {

    //Write createAuthor API with required annotations
    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    public ResponseEntity<String> createAuthor(Author author){
        authorService.create(author);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
}
