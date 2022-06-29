package com.service;

import java.util.ArrayList;

import com.ejbs.Item;
import com.ejbs.Order;
import com.ejbs.User;

public interface UserServiceInterface {
	 public String loginAsUser(User user);
	 public String RegisterUser(User user); 
	 public String createOrder(Order order); //(list of Items)
	 //public ArrayList<Order> viewUserOrder(int id);  //viewOrderByID
	 //public ArrayList<Order> viewAllCustomerOrder();  //ViewAllCustomerOrders
     public String getRoleofCurrentUser();       //getRoleofCurrentUser*/




}
