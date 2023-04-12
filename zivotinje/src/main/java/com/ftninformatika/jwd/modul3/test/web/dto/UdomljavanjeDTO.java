package com.ftninformatika.jwd.modul3.test.web.dto;

import java.time.LocalDateTime;

public class UdomljavanjeDTO {

	private Long id;

	private LocalDateTime datumVreme;

    private Long ljubimacId;

    private String ljubimacIme;

    public UdomljavanjeDTO() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumVreme() {
		return datumVreme;
	}

	public void setDatumVreme(LocalDateTime datumVreme) {
		this.datumVreme = datumVreme;
	}

	public Long getLjubimacId() {
		return ljubimacId;
	}

	public void setLjubimacId(Long ljubimacId) {
		this.ljubimacId = ljubimacId;
	}

	public String getLjubimacIme() {
		return ljubimacIme;
	}

	public void setLjubimacIme(String ljubimacIme) {
		this.ljubimacIme = ljubimacIme;
	}

}
