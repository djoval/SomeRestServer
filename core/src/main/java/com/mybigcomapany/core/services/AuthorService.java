package com.mybigcomapany.core.services;

import com.mybigcomapany.core.entities.AuthorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mybigcomapany.core.repositories.AuthorRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public  Iterable<AuthorEntity> getAll(){
        return authorRepository.findAll();
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

    @Transactional
    public boolean save(AuthorEntity authorEntity) {
        AuthorEntity authorEntityFromDB = authorRepository.findByName(authorEntity.getName());

        if (authorEntityFromDB != null) {
            return false;
        }

        authorRepository.save(authorEntity);
        return true;
    }

    @Transactional
    public boolean update(Long id, AuthorEntity authorEntity) {

        if (authorRepository.findById(id).isEmpty()) {
            return false;
        }

        authorRepository.save(authorEntity);
        return true;
    }

}
