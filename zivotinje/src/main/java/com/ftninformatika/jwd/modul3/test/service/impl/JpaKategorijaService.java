package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Kategorija;
import com.ftninformatika.jwd.modul3.test.repository.KategorijaRepository;
import com.ftninformatika.jwd.modul3.test.service.KategorijaService;

@Service
public class JpaKategorijaService implements KategorijaService{

	@Autowired
    private KategorijaRepository kategorijaRepository;

	@Override
	public List<Kategorija> findAll() {
		return kategorijaRepository.findAll();
	}

	@Override
	public Kategorija findOne(Long id) {
		return kategorijaRepository.findOneById(id);
	}

}
