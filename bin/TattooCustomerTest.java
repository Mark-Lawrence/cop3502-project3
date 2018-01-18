//Michael Arboleda

import static org.junit.Assert.*;

import org.junit.Test;

public class TattooCustomerTest {

	//Checks if the getName method return the correct name
	@Test
	public void testGetName() {
		String ans = "ABC";
		TattooCustomer x = new TattooCustomer(ans, "EFG", 21);
		assertTrue(("Expected: " + ans + "\tRecived from student: " + x.getName()), ans.equals(x.getName()));
	}

	//Checks if the getTattoo method return the correct tattoo
	@Test
	public void testGetTattoo() {
		String ans = "EFG";
		TattooCustomer x = new TattooCustomer("ABC", ans, 21);
		assertTrue(("Expected: " + ans + "\tRecived from student: " + x.getTattoo()), ans.equals(x.getTattoo()));
	}

	//Checks if the getMinutes method return the correct minutes
	@Test
	public void testGetMinutes() {
		int ans = 21;
		TattooCustomer x = new TattooCustomer("ABC", "EFG", ans);
		assertTrue(("Expected: " + ans + "\tRecived from student: " + x.getMinutes()), ans == x.getMinutes());
	}
}