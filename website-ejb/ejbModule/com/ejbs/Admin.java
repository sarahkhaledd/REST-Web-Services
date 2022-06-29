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
public class Admin implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int AdminId ;
   public String AdminName;
   public String AdminPassword ;
   public String role = "Admin";
   public ArrayList<Item> item = new ArrayList<Item>();
   public String getRole() {
	return role;
    }
	   public ArrayList<Item> getItem() {
		return item;
	}
	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}
	public String getAdminName() {
		return AdminName;
	}
	
	public void setAdminName(String AName) {
		this.AdminName = AName;
	}
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int Aid) {
		this.AdminId = Aid;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String password) {
		AdminPassword = password;
	}

   
}
