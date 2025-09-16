package com.bookrental.bboky.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookrental.bboky.dto.LivreDto;
import com.bookrental.bboky.model.Livre;

@Service
public interface LivreService {
    /* List<Livre> findAllLivres();

    List<LivreDto> findAllLivresDto();

    Livre saveLivre(LivreDto livreDto);

    LivreDto findLivreById(String idLivre);

    void updateLivre(LivreDto livre);

    void delete(int idLivre); */

    List<Livre> findLivreNotReturnedOfAuthorInYear(String author, int year);

}
