package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PLACETHEME database table.
 * 
 */
@Entity
@NamedQuery(name="Placetheme.findAll", query="SELECT p FROM Placetheme p")
public class Placetheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;

	//bi-directional many-to-one association to Place
	@ManyToOne
	@JoinColumn(name="PLACEID")
	private Place place;

	//bi-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="THEMEID")
	private Theme theme;

	public Placetheme() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}