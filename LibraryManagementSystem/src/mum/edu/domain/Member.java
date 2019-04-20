package mum.edu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String memberId;
	List<Checkout> checkouts = new ArrayList<Checkout>();
	
	public Member() {}
	
	public Member(String memberId, String firstName, String lastName, String email, String phoneNumber, Address address) {
		super(firstName, lastName, email, phoneNumber, address);
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", checkouts=" + checkouts + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
	

}
