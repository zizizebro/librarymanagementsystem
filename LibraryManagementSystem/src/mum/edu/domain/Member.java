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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((checkouts == null) ? 0 : checkouts.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		Member other = (Member) obj;
		if (checkouts == null) {
			if (other.checkouts != null)
				return false;
		} else if (!checkouts.equals(other.checkouts))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	
	

}
