package com.service;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.app.MyApp;
import com.ejbs.Admin;
import com.ejbs.Item;
import com.ejbs.Order;
import com.ejbs.User;



@Stateless
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class AdminService implements AdminServiceInterface  
{

	@EJB
	@PersistenceContext
	private EntityManager entityManager;
	public ArrayList<User> Arruser = new ArrayList<User>();
	public ArrayList<Admin> Arradmin = new ArrayList<Admin>();

	@POST
	@Path("/register")
	public String RegisterAdmin(Admin admin) {
		Arradmin.add(admin);
		entityManager.persist(admin);
		return "Successfully Registered";
	}
	
	@POST
	@Path("/login")
	public String loginAsAdmin(Admin admin) 
	{
		if(entityManager.contains(admin.AdminName)&&entityManager.contains(admin.AdminPassword))
		{
			return "Successfully login";
		}
			
		return "LOGIN FAIL!";
	}

	@POST
	@Path("/createItem")
	public String CreateAnItem(Item item) 
	{
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item);
		entityManager.persist(item);
		return "Item added Successfully" ;
	}
	
	@POST
	@Path("/viewUserOrder")
	public ArrayList<Order> viewOrder(User user) //id
	{
		
			user = entityManager.find(User.class,user.id);
			if (user != null){
			    return user.getOrder();
			} 
			else
		    return null;
	}
	//	return entityManager.find(User.class, user.id).getOrder();
	
	
	@GET
	@Path("/ViewAllOrder")
	public List<Order> viewAllOrder() {
		
		TypedQuery<Order> query = entityManager.createQuery("SELECT p FROM Order p",Order.class);
		List<Order> order = query.getResultList();
		return order;
	
	
	}
	//@DELETE
	@POST
	@Path("/BlockCutomer")
	public String BlockCutomer(User user) {
		entityManager.remove(user);
		return "BLOCK CUSTOMER";
	}
	
	@GET
	@Path("/RoleofCurrentUser")
	public String getRoleofCurrentUser() 
	{
		Admin admin =new Admin();
		return admin.getRole();
	}


	
	

}
