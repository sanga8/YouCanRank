package com.ycr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    private String titre;
    private Integer point;


	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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
    
}

    