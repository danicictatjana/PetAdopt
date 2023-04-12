package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Udomljavanje;
import com.ftninformatika.jwd.modul3.test.repository.UdomljavanjeRepository;
import com.ftninformatika.jwd.modul3.test.service.UdomljavanjeService;

@Service
public class JpaUdomljavanjeService implements UdomljavanjeService {

	@Autowired
    private UdomljavanjeRepository udomljavanjeRepository;

	@Override
	public List<Udomljavanje> findAll() {
		return udomljavanjeRepository.findAll();
	}

	@Override
	public Udomljavanje findOne(Long id) {
		return udomljavanjeRepository.findOneById(id);
	}

	@Override
	public Udomljavanje save(Udomljavanje udomljavanje) {
       return udomljavanjeRepository.save(udomljavanje);
	}

}
