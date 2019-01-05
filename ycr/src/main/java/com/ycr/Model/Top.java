package com.ycr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Top{
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String titre;
	private String link;
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

	public String getLink()
	{
		return this.link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}
    
}

    