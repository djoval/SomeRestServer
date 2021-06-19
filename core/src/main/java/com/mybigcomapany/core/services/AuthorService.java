package com.mybigcomapany.core.services;

import com.mybigcomapany.core.entities.AuthorEntity;
import com.mybigcomapany.core.services.payloads.AuthorPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mybigcomapany.core.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {


    private final AuthorRepository authorRepository;

    public  List<AuthorEntity> getAll(){
        var it = authorRepository.findAll();
        var authors = new ArrayList<AuthorEntity>();
            it.forEach(e -> authors.add(e));
        return authors;
    }

    public AuthorEntity getById(Long id) {
       Optional<AuthorEntity> userFromDb = authorRepository.findById(id);
            return userFromDb.orElse(new AuthorEntity());
    }

    public boolean delete(Long userId) {
        if (authorRepository.findById(userId).isPresent()) {
            authorRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public boolean save(AuthorPayload authorPayload) {
        AuthorEntity authorEntityFromDB = authorRepository.findByName(authorPayload.getName());

        if (authorEntityFromDB != null) {
            return false;
        }
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(authorPayload.getName());
        authorEntity.setDayOfBirth(authorPayload.getDayOfBirth());
        authorRepository.save(authorEntity);
        return true;
    }

    public boolean update(Long id, AuthorPayload authorPayload) {
        AuthorEntity authorEntityFromDB = authorRepository.findById(id).get();

        if (authorEntityFromDB == null) {
            return false;
        }

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(id);
        authorEntity.setName(authorPayload.getName());
        authorEntity.setDayOfBirth(authorPayload.getDayOfBirth());
        authorRepository.save(authorEntity);
        return true;
    }

}
