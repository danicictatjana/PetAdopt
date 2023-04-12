package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Udomljavanje;

@Repository
public interface UdomljavanjeRepository extends JpaRepository<Udomljavanje,Long>{

	@Override
	List<Udomljavanje> findAll();

	Udomljavanje findOneById (Long id);

	@Override
	Udomljavanje save (Udomljavanje udomljavanje);

}
