package edu.mum.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Address;
import mum.edu.domain.Author;
import mum.edu.domain.Book;
import mum.edu.domain.Checkout;
import mum.edu.domain.Person;
import mum.edu.domain.Member;

public class Tester {

	public static void main(String[] args) {
		
		// Save a book object
//		Address address = new Address("1000 N 4th St", "Fairfield", "IA", "52557");
//		
//		Author author1 = new Author("John", "Doe", "john@gmail.com", "415-789-5745", address, "Dr", "Best seller author");
//		
//		List<Author> authors = new ArrayList<Author>();
//		authors.add(author1);
//		
//		Book book = new Book("123456", "Object Oriented Programming", 20, 30, authors);
//		
//		DataAccessFacde.saveObject(book);

		
		// Read book file to retrieve all books and display them
		DataAccessFacde.setFileName("Book");
		List<Book> books = DataAccessFacde.getFileContents();
		System.out.println(books);
		
		System.out.println("=========================");
		// Read book file to retrieve all books and display them
		DataAccessFacde.setFileName("Member");
		List<Member> members = DataAccessFacde.getFileContents();
		System.out.println(members);
		
		
//		Book b1 = new Book("978-3-16-148410-0", "objectorented", "zini", 10, 14);
//		
//		Person p= new Member("108886", "kidist", "negga", "kikizebro@gmail.com", 1.25) ;
//
//		Person p1 = new Member("986826", "Dave", "Mebrahtu", "dmebrahtu@mum.edu", 0);
//		
//		Checkout checkout = new Checkout();
//		checkout.addBook(b1);
//		checkout.setPerson(p1);
//		checkout.setCheckoutDate(LocalDate.now());
//		checkout.dueDate();
//		
//		System.out.println(checkout);
		
	}

}
