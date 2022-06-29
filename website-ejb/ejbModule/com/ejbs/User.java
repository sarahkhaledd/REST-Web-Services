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
public class User implements Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   public int id ;
	   public String userName;
	   public String Password ;
	   public String role = "User";
	   //@OneToMany (mappedBy="")
		public ArrayList<Order> order = new ArrayList<Order>();

	   public String getRole() {
		return role;
	   }
		public ArrayList<Order> getOrder() {
			return order;
		 }
	   public void setOrder(ArrayList<Order> Order) {
		this.order = Order;
	    }
		public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getPassword() {
				return Password;
			}
			public void setPassword(String password) {
				Password = password;
			}			

}
