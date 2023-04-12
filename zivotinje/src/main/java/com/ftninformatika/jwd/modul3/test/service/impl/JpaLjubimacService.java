package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Ljubimac;
import com.ftninformatika.jwd.modul3.test.repository.LjubimacRepository;
import com.ftninformatika.jwd.modul3.test.service.LjubimacService;

@Service
@Transactional
public class JpaLjubimacService implements LjubimacService {

	@Autowired
    private LjubimacRepository ljubimacRepository;

	@Override
	public Ljubimac findOne(Long id) {
		return ljubimacRepository.findOneById(id);
	}

	@Override
	public Page<Ljubimac> findAll(Integer pageNo) {
		return ljubimacRepository.findAll(PageRequest.of(pageNo,3));
	}

	@Override
	public Ljubimac update(Ljubimac ljubimac) {
		 return ljubimacRepository.save(ljubimac);
	}

	@Override
	public Ljubimac delete(Long id) {
		Ljubimac ljubimac = ljubimacRepository.findOneById(id);
		if(ljubimac != null) {
			ljubimac.getKategorija().getLjubimci().remove(ljubimac);
			ljubimac.setKategorija(null);
			ljubimac = ljubimacRepository.save(ljubimac);
			ljubimacRepository.delete(ljubimac);
			return ljubimac;
		}
		return null;
	}


	@Override
	public Page<Ljubimac> find(Long kategorijaId, String pol, String opis, Integer pageNo) {
		if(opis == null) {
			opis = "%%";
		}else {
			opis = "%" + opis + "%";
		}
		if(kategorijaId == null) {
			return ljubimacRepository.findByPolAndOpisLike(pol, opis, PageRequest.of(pageNo,3));
		}

		if(pol == null) {
			return ljubimacRepository.findByKategorijaIdAndOpisLike(kategorijaId, opis, PageRequest.of(pageNo,3));
		}

		return ljubimacRepository.findByKategorijaIdAndPolAndOpisLike(kategorijaId, pol, opis, PageRequest.of(pageNo,3));
	}

	@Override
	public Ljubimac save(Ljubimac ljubimac) {
		return ljubimacRepository.save(ljubimac);
	}

	@Override
	public List<Ljubimac> findByKategorijaId(Long kategorijaId) {
		return ljubimacRepository.findByKategorijaId(kategorijaId);
	}
}
