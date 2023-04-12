package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Ljubimac;
import com.ftninformatika.jwd.modul3.test.web.dto.LjubimacDTO;

@Component
public class LjubimacToLjubimacDTO implements Converter<Ljubimac, LjubimacDTO>{

	@Override
	public LjubimacDTO convert(Ljubimac ljubimac) {
		LjubimacDTO ljubimacDTO = new LjubimacDTO();
		ljubimacDTO.setId(ljubimac.getId());
		ljubimacDTO.setIme(ljubimac.getIme());
		ljubimacDTO.setStarost(ljubimac.getStarost());
		ljubimacDTO.setVakcinisan(ljubimac.isVakcinisan());
		ljubimacDTO.setPol(ljubimac.getPol());
		ljubimacDTO.setTezina(ljubimac.getTezina());
		ljubimacDTO.setOpis(ljubimac.getOpis());
		ljubimacDTO.setKategorijaId(ljubimac.getKategorija().getId());
		ljubimacDTO.setKategorijaIme(ljubimac.getKategorija().getNaziv());
        return ljubimacDTO;
	}

	public List<LjubimacDTO> convert(List<Ljubimac> ljubimci){
        List<LjubimacDTO> ljubimciDTO = new ArrayList<>();

        for(Ljubimac ljubimac : ljubimci) {
        	ljubimciDTO.add(convert(ljubimac));
        }

        return ljubimciDTO;
    }

}
