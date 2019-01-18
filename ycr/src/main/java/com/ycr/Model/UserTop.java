package com.ycr.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;


@Entity
public class UserTop{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    private Integer id_user;

    private Integer id_top;

    public Integer getId() {
        return this.id;
    }

    /**
     * @return the id_top
     */
    public Integer getId_top() {
        return id_top;
    }

    /**
     * @param id_top the id_top to set
     */
    public void setId_top(Integer id_top) {
        this.id_top = id_top;
    }

    /**
     * @return the id_user
     */
    public Integer getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

}

    