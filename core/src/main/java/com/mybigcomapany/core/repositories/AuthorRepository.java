package com.mybigcomapany.core.repositories;

import com.mybigcomapany.core.entities.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

    public AuthorEntity findByName(String name);
}
