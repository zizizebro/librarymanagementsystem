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
		super();
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
	
	
}
