package com.ycr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class User {

    @Id
    @GeneratedValue
	private int id;
	private String pseudo;
	private String email;
	private String password;

	public User(int id, String pseudo, String password) {
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
	}

	public String getPseudo()
	{
		return this.pseudo;
	}

	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}