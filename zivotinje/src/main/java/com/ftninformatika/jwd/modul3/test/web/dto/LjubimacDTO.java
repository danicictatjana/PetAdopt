package com.ftninformatika.jwd.modul3.test.web.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class LjubimacDTO {

	private Long id;

	@Size(min = 1)
	private String ime;

	private int starost;

	private boolean vakcinisan;

	private String pol;

	@Positive(message = "Tezina nije pozitivan broj.")
	private double tezina;

	private String opis;

	private Long kategorijaId;

	private String kategorijaIme;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getStarost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public boolean isVakcinisan() {
		return vakcinisan;
	}

	public void setVakcinisan(boolean vakcinisan) {
		this.vakcinisan = vakcinisan;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public double getTezina() {
		return tezina;
	}

	public void setTezina(double tezina) {
		this.tezina = tezina;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Long getKategorijaId() {
		return kategorijaId;
	}

	public void setKategorijaId(Long kategorijaId) {
		this.kategorijaId = kategorijaId;
	}

	public String getKategorijaIme() {
		return kategorijaIme;
	}

	public void setKategorijaIme(String kategorijaIme) {
		this.kategorijaIme = kategorijaIme;
	}
}
