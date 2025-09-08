package com.bookrental.bboky.service;

import java.util.List;

import com.bookrental.bboky.dto.ExemplaireDto;
import com.bookrental.bboky.model.Exemplaire;

public interface ExemplaireService {
    void createExemplaire(String idLivre, ExemplaireDto exemplaireDto);

    List<ExemplaireDto> findAllExemplaires(String idLivre);

    List<ExemplaireDto> findAllExemplairesDto();

    List<ExemplaireDto> findExemplaireDtoDisp();

    void updateExemplaire(Exemplaire exemplaire);

    Exemplaire findExemplaireById(String idExemplaire);

    void deleteExemplaire(String idExemplaire);

    void updateDisp(String idExemplaire);

}
