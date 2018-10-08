package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PLACE database table.
 * 
 */
@Entity
@NamedQuery(name="Place.findAll", query="SELECT p FROM Place p")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;

	
	private BigDecimal days;

	private String name;
	
	private String info;

	private BigDecimal price;

	private String transport;
	
	@Lob
	private byte[] photo;
	

//	//bi-directional many-to-one association to Placetheme
//	@OneToMany(mappedBy="place")
//	private List<Placetheme> placethemes;

	public Place() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getDays() {
		return this.days;
	}

	public void setDays(BigDecimal days) {
		this.days = days;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
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
//		placetheme.setPlace(this);
//
//		return placetheme;
//	}
//
//	public Placetheme removePlacetheme(Placetheme placetheme) {
//		getPlacethemes().remove(placetheme);
//		placetheme.setPlace(null);
//
//		return placetheme;
//	}

}