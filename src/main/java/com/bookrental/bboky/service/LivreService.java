package com.bookrental.bboky.service;

import java.util.List;

import com.bookrental.bboky.dto.LivreDto;
import com.bookrental.bboky.model.Livre;

public interface LivreService {
    List<Livre> findAllLivres();

    List<LivreDto> findAllLivresDto();

    Livre saveLivre(LivreDto livreDto);

    LivreDto findLivreById(String idLivre);

    void updateLivre(LivreDto livre);

    void delete(int idLivre);
}
