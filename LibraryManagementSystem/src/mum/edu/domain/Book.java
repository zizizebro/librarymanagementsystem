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
		return "Book [isbn=" + isbn + ", title=" + title + ", numberOfCopies=" + numberOfCopies + ", numberOfDays="
				+ numberOfDays + ", authors=" + authors + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + numberOfCopies;
		result = prime * result + (int) (numberOfDays ^ (numberOfDays >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numberOfCopies != other.numberOfCopies)
			return false;
		if (numberOfDays != other.numberOfDays)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
}
