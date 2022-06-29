package com.service;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ejbs.Item;
import com.ejbs.Order;
import com.ejbs.User;


@Stateless
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService implements UserServiceInterface 
{
	@EJB
	@PersistenceContext
	private EntityManager entityManager;
	public ArrayList<User> Arruser = new ArrayList<User>();

	
	@GET
	@Path("/login")
	public String loginAsUser(User user) {
		if(entityManager.contains(user.userName)&&entityManager.contains(user.Password))
		{
			return "Successfully login";
		}
			
		return "LOGIN FAIL!";
	}

	@POST
	@Path("/register")
	public String RegisterUser(User user) {
		Arruser.add(user);
		entityManager.persist(user);
		return "Successfully Registered";
	}

	@POST
	@Path("/createOrder")
	public String createOrder(Order order) {
		ArrayList<Order> items = new ArrayList<Order>();
		items.add(order);
		entityManager.persist(order);
		return "Order Successfully" ;
	}
    /*
	@GET
	@Path("/viewUserOrder/{id}")
	public ArrayList<Order> viewUserOrder(@PathParam("id") int id) 
	{
		
	}*/

	@GET
	@Path("/RoleofCurrentUser")
	public String getRoleofCurrentUser() {
		// TODO Auto-generated method stub
		User user = new User();
		return user.getRole();
	}

}
