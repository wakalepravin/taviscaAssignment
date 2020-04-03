package com.src.beveragefactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFactory {

	Map<String,MenuItem> menus = new HashMap<String, MenuItem>();
	Map<String,Double> ingredients = new HashMap<String, Double>();
	
	public void setIngredients() {
		ingredients.put("-Milk".toLowerCase(), 1.0);
		ingredients.put("-Sugar".toLowerCase(), 0.5);
		ingredients.put("-Soda".toLowerCase(), 0.5);
		ingredients.put("-Mint".toLowerCase(), 0.5);
		ingredients.put("-Water".toLowerCase(), 0.5);
	}
	
	public void setMenuItem() {
		menus.put("Coffee".toLowerCase(),new MenuItem("Coffee".toLowerCase(), "-Coffee, -Milk, -Sugar, -Water".toLowerCase(), 5.0));
		menus.put("Chai".toLowerCase(), new MenuItem("Chai".toLowerCase(), "-Tea, -Milk, -Sugar, -Water".toLowerCase(), 4.0));
		menus.put("Banana Smoothie".toLowerCase(), new MenuItem("Banana Smoothie".toLowerCase(), "-Banana, -Milk, -Sugar, -Water".toLowerCase(), 6.0));
		menus.put("Strawberry Shake".toLowerCase(), new MenuItem("Strawberry Shake".toLowerCase(), "-Strawberries, -Sugar, -Milk, -Water".toLowerCase(), 7.0));
		menus.put("Mojito".toLowerCase(), new MenuItem("Mojito".toLowerCase(), "-Lemon, -Sugar, -Water, -Soda, -Mint".toLowerCase(), 7.5));
	}
	
	public List<String> getOrdersList(){
		String orderArr[] = {"Chai, -Sugar", "Chai", "Chai, -Sugar, -Milk", "Coffee", "Milk"};
		return Arrays.asList(orderArr);
	}
	
	public List<String> getSingleOrder(String orderData){
		return Arrays.asList(orderData.toLowerCase().split(","));
	}
	
	
	public double computeTotalPrice(List<String> order) {
		Double price = menus.get(order.get(0)).getItemPrice();
		if (order.size() > 0) {
			for (int i = 1; i < order.size(); i++) {
				if (!ingredients.containsKey(order.get(i).trim())) {
					return -1;
				}
				price -= ingredients.get(order.get(i).trim());
			}
		}
		return price;
	}
	public static void main(String[] args) {
		
		BFactory bf = new BFactory();
		bf.setIngredients();
		bf.setMenuItem();
		
		List<String> orderLst = bf.getOrdersList();
		
		for (String orderData : orderLst) {
			List<String> order = bf.getSingleOrder(orderData);
			if(order.size()>0) {
				if(bf.menus.get(order.get(0))==null) {
					System.out.println("Invalid Menu Item.");
					continue;
				}
				double price = bf.computeTotalPrice(order);
				if(price ==-1) {
					System.out.println("Invalid Ingredients.");
				}else {
					System.out.println("Item Name:" + order.get(0) + ", Price: " + price);
				}
			}else {
				System.out.println("Order is not valid.");
				continue;
			}
		}
	}
}