package com.mybigcomapany.core.controllers;

import com.mybigcomapany.core.entities.AuthorEntity;
import com.mybigcomapany.core.services.payloads.AuthorPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.mybigcomapany.core.services.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/GetById/{id}")
    public AuthorEntity getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @GetMapping("/GetAll")
    public List<AuthorEntity> getAll() {
        return authorService.getAll();
    }

    @PostMapping("/Save")
    public boolean save(@RequestBody AuthorPayload authorPayload){
        return authorService.save(authorPayload);
    }

    @PutMapping("/Update/{id}")
    public boolean update(@PathVariable Long id, @RequestBody AuthorPayload authorPayload){
        return authorService.update(id, authorPayload);
    }

    @DeleteMapping("/Delete/{id}")
    public boolean delete(@PathVariable Long id){
        return authorService.delete(id);
    }
}
