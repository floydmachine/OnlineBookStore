package com.ars.pro1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Admin")

public class LoginAdmin {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@NotEmpty(message = "Please enter your username.")
	private String username;
	@NotEmpty(message = "Please enter your password.")
	@Size(min = 4, max = 20, message = "Your password must between 4 and 20 characters")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

  public LoginAdmin(String username, String password)
  {
    super();
 
    this.username = username;
    this.password = password;
  }

  public LoginAdmin()
  {
    super();
  }

  
}
