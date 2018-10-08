package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="USER_gen")
	@SequenceGenerator(name="USER_gen",sequenceName="USER_SEQ",initialValue=2,allocationSize=1)
	private long id;

	private String email;

	private BigDecimal mobile;

	private String password;

	
	private String role;

	private String username;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getMobile() {
		return this.mobile;
	}

	public void setMobile(BigDecimal mobile) {
		this.mobile = mobile;
	}
	
	public String getMobileS() {
		return this.mobile.toString();
	}

	public void setMobileS(String mobile) {
		this.mobile = new BigDecimal(mobile);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}