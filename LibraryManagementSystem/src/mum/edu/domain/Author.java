package mum.edu.domain;

import java.io.Serializable;

public class Author extends Person  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	String qualification;
	String biography;
	
	public Author() {}
	
	public Author(String firstName, String lastName, String email, String phoneNumber, Address address, String qualification, String biography) {
		super(firstName, lastName, email, phoneNumber, address );
		this.qualification = qualification;
		this.biography = biography;
	
	}

	@Override
	public String toString() {
		return "Author [qualification=" + qualification + ", biography=" + biography + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address="
				+ address + "]";
	}

}
