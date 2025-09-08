package com.bookrental.bboky.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookrental.bboky.dto.PretDto;

import com.bookrental.bboky.model.Pret;

@Service
public interface PretService {
    Pret savePret(PretDto pretDto, String idUser, String idExemplaire);

    List<Pret> findAllPrets();

    List<PretDto> findAllPretsDto();

    void delete(String idPret);
}