package com.ftninformatika.jwd.modul3.test.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ljubimac {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private String ime;

	@Column
	private int starost;

	@Column(nullable = false)
	private boolean vakcinisan;

	@Column(nullable = false)
	private String pol;

	@Column(nullable = false)
	private double tezina;

	@Column(nullable = false)
	private String opis;

	@ManyToOne
	private Kategorija kategorija;

	public Ljubimac() {
        super();
    }

	public Ljubimac(Long id, String ime, int starost, boolean vakcinisan, String pol, double tezina, String opis,
			Kategorija kategorija) {
		super();
		this.id = id;
		this.ime = ime;
		this.starost = starost;
		this.vakcinisan = vakcinisan;
		this.pol = pol;
		this.tezina = tezina;
		this.opis = opis;
		this.kategorija = kategorija;
	}

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

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Ljubimac other = (Ljubimac) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ljubimac [id=" + id + ", ime=" + ime + ", starost=" + starost + ", vakcinisan=" + vakcinisan + ", pol="
				+ pol + ", tezina=" + tezina + ", opis=" + opis + ", kategorija=" + kategorija + "]";
	}
}
