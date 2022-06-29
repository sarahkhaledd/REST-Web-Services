package com.service;

import java.util.ArrayList;
import java.util.List;

import com.ejbs.Admin;
import com.ejbs.Item;
import com.ejbs.Order;
import com.ejbs.User;

public interface AdminServiceInterface {
      
	  public String RegisterAdmin(Admin admin); 
	  public String loginAsAdmin(Admin admin);
	  public String CreateAnItem(Item item);//admin
	  public ArrayList<Order> viewOrder(User user);   //adminn ViewOrdersByCustomerId 
	  public List<Order> viewAllOrder();        //viewAllOrders
	  public String BlockCutomer(User user);          // blockCustomer
	  public String getRoleofCurrentUser();          //getRoleofCurrentUser
	  
}
