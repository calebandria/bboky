package com.bookrental.bboky.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookrental.bboky.model.Livre;

public interface LivreRepository extends MongoRepository<Livre, String> {
    
}
