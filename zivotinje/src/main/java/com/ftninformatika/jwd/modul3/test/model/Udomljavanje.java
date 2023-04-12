package com.ftninformatika.jwd.modul3.test.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Udomljavanje {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private LocalDateTime datumVreme;

	@OneToOne
	private Ljubimac ljubimac;

	public Udomljavanje() {
		super();
	}

	public Udomljavanje(Long id, LocalDateTime datumVreme, Ljubimac ljubimac) {
		super();
		this.id = id;
		this.datumVreme = datumVreme;
		this.ljubimac = ljubimac;
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

	public Ljubimac getLjubimac() {
		return ljubimac;
	}

	public void setLjubimac(Ljubimac ljubimac) {
		this.ljubimac = ljubimac;
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
		Udomljavanje other = (Udomljavanje) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Udomljavanje [id=" + id + ", datumVreme=" + datumVreme + ", ljubimac=" + ljubimac + "]";
	}

}
