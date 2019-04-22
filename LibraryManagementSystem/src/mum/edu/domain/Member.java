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
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<Checkout> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Checkout> checkouts) {
		this.checkouts = checkouts;
	}

	public void addCheckoutRecord(Checkout checkout) {
		this.checkouts.add(checkout);
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", checkouts=" + checkouts + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
}
