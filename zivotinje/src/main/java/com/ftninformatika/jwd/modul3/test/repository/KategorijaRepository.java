package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Kategorija;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija,Long>{

	@Override
	List<Kategorija> findAll();

	Kategorija findOneById (Long id);

}
