package com.bookrental.bboky.model;

import java.time.LocalDateTime;
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
    private LocalDateTime dateOfEdition;
    private List<Exemplaire> copies;
}