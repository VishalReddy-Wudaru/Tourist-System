package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the THEME database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;

	private String theme;
	
	@Lob
	private byte[] photo;

//	//bi-directional many-to-one association to Placetheme
//	@OneToMany(mappedBy="theme")
//	private List<Placetheme> placethemes;

	public Theme() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

//	public List<Placetheme> getPlacethemes() {
//		return this.placethemes;
//	}
//
//	public void setPlacethemes(List<Placetheme> placethemes) {
//		this.placethemes = placethemes;
//	}
//
//	public Placetheme addPlacetheme(Placetheme placetheme) {
//		getPlacethemes().add(placetheme);
//		placetheme.setTheme(this);
//
//		return placetheme;
//	}
//
//	public Placetheme removePlacetheme(Placetheme placetheme) {
//		getPlacethemes().remove(placetheme);
//		placetheme.setTheme(null);
//
//		return placetheme;
//	}

}