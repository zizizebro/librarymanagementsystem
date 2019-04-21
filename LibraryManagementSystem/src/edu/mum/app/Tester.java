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

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// Read book file to retrieve all books and display them
		DataAccessFacde.setFileName("Book");
		List<Book> books = DataAccessFacde.getFileContents();
		for(Book book: books) {
			System.out.println(book);
		}
		
		
		System.out.println("###==========###===============###");
		// Read Member file to retrieve all members and display them
		DataAccessFacde.setFileName("Member");
		List<Member> members = DataAccessFacde.getFileContents();
		//System.out.println("NUMBER OF MEMBERS: " + members.size());
		for(Member member: members) {
			System.out.println(member);
		}
		
		System.out.println("###==========###===============###");
		List<Book> b = new ArrayList<>();
		b.add(books.get(2));
		Checkout co = new Checkout(b, members.get(0), LocalDate.now(), LocalDate.now().plusDays(14));

		
		// Read Member file to retrieve all members and display them
		DataAccessFacde.setFileName("Checkout");
//		DataAccessFacde.saveObject(co);
		List<Checkout> checkouts = DataAccessFacde.getFileContents();
//		System.out.println(checkouts.get(1));
		checkouts.remove(0);
		for(Checkout checkout: checkouts) {
			System.out.println(checkout);
		}
		
	}
}
