package com.bookrental.bboky.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bookrental.bboky.model.Livre;

public interface LivreRepository extends MongoRepository<Livre, String> {
    
    @Query("{ 'author' : ?0, 'dateOfEdition' : { '$gte' : ?1, '$lt' : ?2 }, 'copies.disponible' : false }")
    List<Livre> findNonAvailableBooksByAuthorAndYear(String author, LocalDateTime startOfYear, LocalDateTime endOfYear);

}