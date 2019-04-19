package mum.edu.domain;

import java.io.Serializable;
import java.util.List;

public class Member extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String memberId;
	List<Checkout> checkouts;
	
	public Member() {}

	public Member(String firstName, String lastName, String email, String phoneNumber, Address address, String memberId, List<Checkout> checkouts) {
		super(firstName, lastName, email, phoneNumber, address);
		this.memberId = memberId;
		this.checkouts = checkouts;
	}
	
	
	

}
