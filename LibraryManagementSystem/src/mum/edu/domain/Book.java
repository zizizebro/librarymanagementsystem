package mum.edu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String isbn;
	private String title;
	private int numberOfCopies;
	private long numberOfDays;  // to count how many day do we have to return the book
	private List<Author> authors = new ArrayList<Author>();

	public Book() {}
	
	
	public Book(String isbn, String title, int numberOfCopies, long numberOfDays, List<Author> authors) {
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.numberOfCopies = numberOfCopies;
		this.numberOfDays = numberOfDays;
	}


	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Author> getAuthor() {
		return authors;
	}
	public void setAuthor(List<Author> authors) {
		this.authors = authors;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public long getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}


	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + authors + ", numberOfCopies=" + numberOfCopies
				+ ", numberOfDays=" + numberOfDays + "]";
	} 
	
	

}
