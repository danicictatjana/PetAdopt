package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Ljubimac;

@Repository
public interface LjubimacRepository extends JpaRepository<Ljubimac,Long>{

	Ljubimac findOneById(Long id);

	List<Ljubimac> findByKategorijaId(Long kategorijaId);

	Page<Ljubimac> findByKategorijaIdAndPolAndOpisLike(Long kategorijaId, String pol, String opis, Pageable pageable);

	Page<Ljubimac> findByOpisLike(String opis, Pageable pageable);

	Page<Ljubimac> findByKategorijaIdAndOpisLike(Long kategorijaId, String opis, Pageable pageable);

	Page<Ljubimac> findByPol(String pol, Pageable pageable);

	Page<Ljubimac> findByPolAndOpisLike(String pol, String opis, Pageable pageable);

	Page<Ljubimac> findByKategorijaIdAndPol(Long kategorijaId, String pol, Pageable pageable);




}
