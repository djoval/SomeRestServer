package com.mybigcomapany.core.controllers;

import com.mybigcomapany.core.entities.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.mybigcomapany.core.services.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/getbyid/{id}")
    public AuthorEntity getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @GetMapping("/getall")
    public Iterable<AuthorEntity> getAll() {
        return authorService.getAll();
    }

    @PostMapping("/save")
    public boolean save(@RequestBody AuthorEntity authorEntity){
        return authorService.save(authorEntity);
    }

    @PutMapping("/update/{id}")
    public boolean update(@PathVariable Long id, @RequestBody AuthorEntity authorEntity){
        return authorService.update(id, authorEntity);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return authorService.delete(id);
    }
}
