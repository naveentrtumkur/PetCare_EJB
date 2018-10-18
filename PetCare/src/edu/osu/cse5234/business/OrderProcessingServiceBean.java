package edu.osu.cse5234.business;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	ServiceLocator.getInventoryService().validateQuantity(order.getItems());
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	inventoryService.updateInventory(order.getItems());
    	
    	int max = 9999;
    	int min = 1000;
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(max - min + 1) + min;

    	return String.valueOf(randomNumber);
    }

    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
    }

}
