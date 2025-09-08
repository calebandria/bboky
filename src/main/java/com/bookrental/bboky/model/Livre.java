package com.bookrental.bboky.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data; 

@Data 
@Document(collection = "livres")
public class Livre {
    @Id
    private String id;
    private String title;
    private String author;
    private String editor;
    private List<Exemplaire> copies;
    
}