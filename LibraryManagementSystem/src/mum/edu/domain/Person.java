package mum.edu.domain;

import java.io.Serializable;

public abstract class Person  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	Address address;
	
	public Person() {}

	public Person(String firstName, String lastName, String email, String phoneNumber, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
	

}
