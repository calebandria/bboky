package com.bookrental.bboky.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "exemplaires")
public class Exemplaire {
    @Id
    private String id;
    private boolean disponible;
    
}
