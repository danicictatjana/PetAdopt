package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Ljubimac;

public interface LjubimacService {

	Ljubimac findOne(Long id);

    Page<Ljubimac> findAll(Integer pageNo);

    Ljubimac save(Ljubimac ljubimac);

    Ljubimac update(Ljubimac ljubimac);

    Ljubimac delete(Long id);

    Page<Ljubimac> find(Long kategorijaId, String pol, String opis, Integer pageNo);

    List<Ljubimac> findByKategorijaId(Long kategorijaId);

}
