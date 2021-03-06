package com.ycr.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;


@Entity
public class Top{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer id_creator;

	private String titre;

	private String link;

	private Integer point = 0;

	private Integer id_categorie;

	public Integer getId() {
		return this.id;
	}

	public Integer getId_creator() {
		return id_creator;
	}

	public void setId_creator(Integer id_creator) {
		this.id_creator = id_creator;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId_categorie()
	{
		return this.id_categorie;
	}

	public void setId_categorie(Integer id_categorie)
	{
		this.id_categorie = id_categorie;
	}

	public String getTitre()
	{
		return this.titre;
	}

	public void setTitre(String titre)
	{
		this.titre = titre;
	}

	public Integer getPoint()
	{
		return this.point;
	}

	public void setPoint(Integer point)
	{
		this.point = point;
	}

	public String getLink()
	{
		return this.link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}
    
}

    