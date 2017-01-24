package junit;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Customer {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date dateOfBirth;
	private Integer age;

	// Constructors, getters, setters
	public Customer()
	{
		super();
	}
	
	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public void calculateAge() {
//		if (dateOfBirth == null) {
//			age = null;
//			return;
//		}
		Calendar birth = new GregorianCalendar();
		birth.setTime(dateOfBirth);
		Calendar now = new GregorianCalendar();
		now.setTime(new Date());
		int adjust = 0;
		if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
			adjust = -1;
		}
		age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + adjust;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
}