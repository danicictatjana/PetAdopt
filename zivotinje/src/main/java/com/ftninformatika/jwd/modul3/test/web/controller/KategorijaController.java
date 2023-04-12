package com.ftninformatika.jwd.modul3.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.model.Kategorija;
import com.ftninformatika.jwd.modul3.test.service.KategorijaService;
import com.ftninformatika.jwd.modul3.test.support.KategorijaToKategorijaDTO;
import com.ftninformatika.jwd.modul3.test.web.dto.KategorijaDTO;

@RestController
@RequestMapping(value = "/api/kategorije", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class KategorijaController {

	 @Autowired
	 private KategorijaService kategorijaService;

	 @Autowired
	 private KategorijaToKategorijaDTO kategorijaToKategorijaDTO;

	 @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	 @GetMapping
	 public ResponseEntity<List<KategorijaDTO>> getAll(){

		List<Kategorija> kategorije = kategorijaService.findAll();

		return new ResponseEntity<>(kategorijaToKategorijaDTO.convert(kategorije), HttpStatus.OK);
	}





}
