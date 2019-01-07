package com.ycr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Question{
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String titre;
	private String link;
    private Integer point;
    private Integer top_id;


	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
    }
    
    public Integer getTop_id()
	{
		return this.top_id;
	}

	public void setTop_id(Integer top_id)
	{
		this.top_id=top_id;
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

    