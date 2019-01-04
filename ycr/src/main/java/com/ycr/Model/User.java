package com.ycr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
//@Table (name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String pseudo;
	private String password;
	
	public String getPseudo()
	{
		return this.pseudo;
	}

	public void setPseudo(String pseudo)
	{
		this.pseudo = pseudo;
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