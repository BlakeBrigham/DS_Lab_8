import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ComparatorsTest {

	
	Customer c1;
	Customer c2;
	Customer c3;
	Customer c4;
	PriorityQueue<Customer> q1;
	Customer.WorthComparator wc;
	Customer.LoyaltyComparator lc;
	Customer.WorthPoliteComparator wpc;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Customer(10, 10, 10);
		c2 = new Customer(2, 5, 8);
		c3 = new Customer(2, 8, 5);
		c4 = new Customer(1, 1, 1);
		
		wc = new Customer.WorthComparator();
		lc = new Customer.LoyaltyComparator();
		wpc = new Customer.WorthPoliteComparator();
		
		q1 = new PriorityQueue<Customer>(lc);
	}
	
	@Test
	void Comparatortest() {
		//WorthComparator
		assertTrue(wc.compare(c1, c2) > 0);
		assertTrue(wc.compare(c2,c1) < 0);
		assertTrue(wc.compare(c1, c3) > 0);
		assertTrue(wc.compare(c3, c1) < 0);
		assertTrue(wc.compare(c2, c3) == 0);
		assertTrue(wc.compare(c3, c2) == 0);
		
		//Loyalty
		assertTrue(lc.compare(c1, c2) > 0);
		assertTrue(lc.compare(c2,c1) < 0);
		assertTrue(lc.compare(c1, c3) > 0);
		assertTrue(lc.compare(c3, c1) < 0);
		assertTrue(lc.compare(c2, c3) < 0);
		assertTrue(lc.compare(c3, c2) > 0);
		
		//WorthPoliteComparator
		assertTrue(wpc.compare(c1, c2) > 0);
		assertTrue(wpc.compare(c2,c1) < 0);
		assertTrue(wpc.compare(c1, c3) > 0);
		assertTrue(wpc.compare(c3, c1) < 0);
		assertTrue(wpc.compare(c2, c3) > 0);
		assertTrue(wpc.compare(c3, c2) < 0);
		
		
		
	}

	@Test
	void PriorityQueueTest() {
		//WorthComparator
		assertTrue(q1.isEmpty());
		q1.push(c1);
		assertFalse(q1.isEmpty());
		assertEquals(c1, q1.pop());
		q1.push(c2);
		q1.push(c1);
		q1.push(c3);
		q1.push(c4);
		assertEquals(c1, q1.pop());
		assertEquals(c3, q1.pop());
		assertEquals(c2, q1.pop());
		assertEquals(c4, q1.pop());
		assertTrue(q1.isEmpty());
		
		
	}
}
