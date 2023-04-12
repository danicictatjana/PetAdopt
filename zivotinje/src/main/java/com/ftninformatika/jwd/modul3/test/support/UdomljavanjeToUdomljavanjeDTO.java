package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Udomljavanje;
import com.ftninformatika.jwd.modul3.test.web.dto.UdomljavanjeDTO;

@Component
public class UdomljavanjeToUdomljavanjeDTO implements Converter<Udomljavanje, UdomljavanjeDTO> {

	@Override
	public UdomljavanjeDTO convert(Udomljavanje udomljavanje) {
		UdomljavanjeDTO dto = new UdomljavanjeDTO();
        dto.setId(udomljavanje.getId());
        dto.setDatumVreme(udomljavanje.getDatumVreme());
        return dto;
	}

	public List<UdomljavanjeDTO> convert(List<Udomljavanje> udomljavanja){
        List<UdomljavanjeDTO> udomljavanjeDto = new ArrayList<>();

        for(Udomljavanje udomljavanje : udomljavanja) {
        	udomljavanjeDto.add(convert(udomljavanje));
        }

        return udomljavanjeDto;
    }

}
