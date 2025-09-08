package com.bookrental.bboky.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bookrental.bboky.model.Exemplaire;

public interface ExemplaireRepository extends MongoRepository<Exemplaire, String>{
    
}
