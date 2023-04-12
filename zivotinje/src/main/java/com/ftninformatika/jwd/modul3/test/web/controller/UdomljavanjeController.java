package com.ftninformatika.jwd.modul3.test.web.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.model.Ljubimac;
import com.ftninformatika.jwd.modul3.test.model.Udomljavanje;
import com.ftninformatika.jwd.modul3.test.service.LjubimacService;
import com.ftninformatika.jwd.modul3.test.service.UdomljavanjeService;
import com.ftninformatika.jwd.modul3.test.support.UdomljavanjeToUdomljavanjeDTO;
import com.ftninformatika.jwd.modul3.test.web.dto.UdomljavanjeDTO;

@RestController
@RequestMapping(value = "/api/udomljavanja", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UdomljavanjeController {

	@Autowired
	 private UdomljavanjeService udomljavanjeService;

	@Autowired
	 private LjubimacService ljubimacService;

	 @Autowired
	 private UdomljavanjeToUdomljavanjeDTO toUdomljavanjeDTO;

	 @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	 @PutMapping("/{id}")
	   public ResponseEntity<UdomljavanjeDTO> getOne(@PathVariable Long id){
	        Ljubimac ljubimac = ljubimacService.findOne(id);

	        if(ljubimac != null && ljubimac.isVakcinisan()) {

	        Udomljavanje udomljavanje = new Udomljavanje();
	        udomljavanje.setLjubimac(ljubimac);
	        LocalDateTime now = LocalDateTime.now();
	        udomljavanje.setDatumVreme(now);
	        Udomljavanje sacuvanoUdomljavanje = udomljavanjeService.save(udomljavanje);
	            return new ResponseEntity<>(toUdomljavanjeDTO.convert(sacuvanoUdomljavanje), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }



}
