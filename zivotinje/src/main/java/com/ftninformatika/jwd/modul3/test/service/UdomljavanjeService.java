package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.test.model.Udomljavanje;

public interface UdomljavanjeService {

	List<Udomljavanje> findAll();

	Udomljavanje findOne(Long id);

	Udomljavanje save (Udomljavanje udomljavanje);

}
