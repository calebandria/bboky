package com.bookrental.bboky.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookrental.bboky.model.Pret;

public interface PretRepository extends MongoRepository<Pret,String> {
    
}
