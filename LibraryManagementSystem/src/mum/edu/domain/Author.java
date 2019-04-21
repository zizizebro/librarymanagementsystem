package mum.edu.domain;

import java.io.Serializable;

public class Author extends Person  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	String biography;
	
	public Author() {}
	
	public Author(String firstName, String lastName, String email, String phoneNumber, Address address, String biography) {
		super(firstName, lastName, email, phoneNumber, address );
		this.biography = biography;
	
	}

	@Override
	public String toString() {
		return "Author [biography=" + biography + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address="
				+ address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((biography == null) ? 0 : biography.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (biography == null) {
			if (other.biography != null)
				return false;
		} else if (!biography.equals(other.biography))
			return false;
		return true;
	}
	
	

}
