package com.bookrental.bboky.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookrental.bboky.model.Livre;
import com.bookrental.bboky.repository.LivreRepository;
import com.bookrental.bboky.service.LivreService;

@Service
public class LivreServiceImpl implements LivreService {
    public LivreRepository livreRepository;

    public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public List<Livre> findLivreNotReturnedOfAuthorInYear(String author, int year) {
        LocalDateTime startOfYear = LocalDate.of(year, 1, 1).atStartOfDay();
        LocalDateTime endOfYear = LocalDate.of(year, 12, 31).atTime(LocalTime.MAX);
        return livreRepository.findNonAvailableBooksByAuthorAndYear(author, startOfYear, endOfYear);
    }
}