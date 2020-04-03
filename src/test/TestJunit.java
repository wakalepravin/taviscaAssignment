package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.src.beveragefactory.BFactory;

class TestJunit {
	BFactory bf = new BFactory();
	
	// Check that each order has at least one menu item
	@Test
	void testSizeOfAllOrders() {
		List<String> orderList = bf.getOrdersList();
		assertTrue(orderList.size()>0);
	}
	
	@Test
	void testEmptyOrders() {
		boolean expected = true;
		boolean actual = true;
		List<String> orderList = bf.getOrdersList();
		for (String order : orderList) {
			if(order == null || order.equals("")) {
				actual = false;
				break;
			}
		}
		assertEquals(actual,expected);
	}
}
