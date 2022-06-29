package com.ejbs;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@LocalBean
public class Order implements Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	//@ManyToOne
    public User user;
	//@OneToMany
    public ArrayList<Item> item = new ArrayList<Item>();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Item> getItem() {
		return item;
	}
	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

}
