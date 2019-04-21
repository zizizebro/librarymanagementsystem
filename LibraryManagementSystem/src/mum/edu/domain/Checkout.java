package mum.edu.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Checkout implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	List<Book> books = new ArrayList<Book>();
	Member member;
	LocalDate checkoutDate;
	LocalDate dueDate;
	
	public Checkout() {
		
	}
	
	public Checkout(List<Book> books, Member member, LocalDate checkoutDate, LocalDate dueDate) {
		this.books = books;
		this.member = member;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}


	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public void dueDate() {
		this.dueDate = this.checkoutDate.plusDays( this.books.get(0).getNumberOfDays());
	}

	@Override
	public String toString() {
		return "Checkout [books=" + books + ", member=" + member + ", checkoutDate=" + checkoutDate + ", dueDate="
				+ dueDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((checkoutDate == null) ? 0 : checkoutDate.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checkout other = (Checkout) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (checkoutDate == null) {
			if (other.checkoutDate != null)
				return false;
		} else if (!checkoutDate.equals(other.checkoutDate))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		return true;
	}
	
	
	
}
