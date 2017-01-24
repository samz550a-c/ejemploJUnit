package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CustomerTest {
	private Customer customer;

	@Before
	public void clearCustomer() {
		customer = null;
	}

	@Test
	public void ageShouldBeGretaterThanZero() {
		customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com");
		
		customer.setDateOfBirth(new GregorianCalendar(1975, 5, 27).getTime());
		
		customer.calculateAge();
		
		int calculatedAge = customer.getAge();
		
		assertTrue(calculatedAge >= 0);
	}

	@Test
	public void ageShouldBe42() {
		int expectedAge = 42;
		Calendar birth = new GregorianCalendar();
		
		birth.roll(Calendar.YEAR, expectedAge * (-1));
		birth.roll(Calendar.DAY_OF_YEAR, -1);
		
		customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com");
		
		customer.setDateOfBirth(birth.getTime());
		customer.calculateAge();
		
		assertEquals(new Long(expectedAge), new Long(customer.getAge()));
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowAnExceptionCauseDateOfBirtheIsNull() {
		customer = new Customer();
		customer.calculateAge();
	}

	@Test
	@Ignore("Test is not ready yet")
	public void shouldCalculateOldAge() {
		// some work to do
	}
}