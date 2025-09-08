package com.bookrental.bboky.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "prets")
public class Pret {
    @Id
    private String id;
    private LocalDateTime datePret;
    private LocalDateTime dateRemise;
    private List<Exemplaire> livres;
}
