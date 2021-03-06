package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;

import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@WebServiceRef(wsdlLocation = 
	       "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")

//private PaymentProcessorService service;

@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	
	@PersistenceContext
	EntityManager entityManager;
	private PaymentProcessorService service;
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String processOrder(Order order) {
    	PaymentInfo paymentInfo = order.getPayment();
    	//String name, int number, int expiration, int cvv, int amount
    	CreditCardPayment ccPayment = CreditCardPayment("naveen", 23, 23, 456, 322, 50);
    	List<LineItem> lineItems = order.getLineItems();
    	List<Item> items = lineItems2Items(lineItems);
    	
    	boolean valid = ServiceLocator.getInventoryService().validateQuantity(items);
    	InventoryService inventoryService = ServiceLocator.getInventoryService();
    	if (valid) {
    		entityManager.persist(order);
    		entityManager.flush();  // ensure all entities related to Order are saved to the database
    		inventoryService.updateInventory(items);
		}
    	
    	int max = 9999;
    	int min = 1000;
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(max - min + 1) + min;

    	return String.valueOf(randomNumber);
    }
    
    public List<Item> lineItems2Items(List<LineItem> lineItems) {
    	List<Item> items = new ArrayList<>();
    	
    	for (LineItem lineItem : lineItems) {
    		String itemName = lineItem.getItemName();
    		int quantity = lineItem.getQuantity();
    		Item item = new Item(itemName, quantity);
    		items.add(item);
    	}
    	
		return items;
    }

    public boolean validateItemAvailability(Order order) {
    	List<LineItem> lineItems = order.getLineItems();
    	List<Item> items = lineItems2Items(lineItems);
    	return ServiceLocator.getInventoryService().validateQuantity(items);
    }

}
