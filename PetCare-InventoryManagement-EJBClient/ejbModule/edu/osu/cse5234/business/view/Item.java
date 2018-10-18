package edu.osu.cse5234.business.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="ITEM")
public class Item implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5238185927943559551L;
	
	@Column(name="id")
	private int id;
	
	@Column(name="itemnumber")
	private int item_number;
	
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="unit_price")
	private String unit_price;
	
	@Column(name="available_quantity")
	private int available_quantity;
	
	@Column(name="description")
	private String description;
	
	public Item() {}
	
	public Item(String name, String price, int quantity) {
		this.name = name;
		this.unit_price = price;
		this.available_quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return unit_price;
	}
	
	public void setPrice(String price) {
		this.unit_price = price;
	}
	
	public int getQuantity() {
		return available_quantity;
	}

	public void setQuantity(int quantity) {
		this.available_quantity = quantity;
	}
}
