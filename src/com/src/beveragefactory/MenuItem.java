package com.src.beveragefactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuItem {

	private String itemName;
	private List<String> itemIng = new ArrayList<String>();
	private Double itemPrice;
	
	public MenuItem() {

	}
	public MenuItem(String itemName, String ingList, Double price) {
	
		this.itemName = itemName;
		this.itemIng = Arrays.asList(ingList.split(","));
		this.itemPrice = price;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

}
