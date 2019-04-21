package edu.mum.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mum.edu.domain.Book;
import mum.edu.domain.Member;

public class DataAccessFacde {
	
	private static List fileContents = new ArrayList<>();
	private static String fileName = null;
	private static HashMap<String, Book> books = new HashMap<>();
	private static HashMap<String, Member> members = new HashMap<>();

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "//src//edu//mum//db//";

	public static void setFileName(String fName) {
		fileName = fName;
	}

//	public static void setFileContents(List contents) {
//		fileContents = contents;
//	}

	public static List getFileContents() {
		readFile();
		return fileContents;
	}

	public static void saveObject(Object obj) {
		if (obj != null) {
			fileName = obj.getClass().getSimpleName();
			readFile();
			fileContents.add(obj);
			writeObject(fileContents);
		}
	}

	public static void writeObject(List obj) {

		// fileName = obj.getClass().getSimpleName();
		System.out.println("writing to file: " + fileName);
		try {

			FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_DIR + fileName);
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			output.writeObject(obj);

			fileName = null;
			output.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void readFile() {
		// System.out.println("reading from file: " + fileName);

		try {
			FileInputStream fileInputStream = new FileInputStream(new File(OUTPUT_DIR + fileName));

			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			//fileContents = (ArrayList<Book>) input.readObject();

				if(fileName.equals("Member"))

					fileContents =  (ArrayList<Member>) input.readObject();

				else if(fileName.equals("Book"))

					fileContents =  (ArrayList<Book>) input.readObject();

				else

						fileContents =  (List)input.readObject(); //(ArrayList<Periodical>)input.readObject();

			input.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			// e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	//******************** Search Methods **************//
	public static Book  getBook(String isbnNumber) {
		fileName = "Book";
		readFile();
		for(Object obj: fileContents) {
			Book b = (Book)obj;
			books.put(b.getIsbn(), b);
		}
		
		if(books.containsKey(isbnNumber))
			return books.get(isbnNumber);
		
		return null;
	}
	
	public static Member  getMember(String memberId) {
		fileName = "Member";
		readFile();
		for(Object obj: fileContents) {
			Member m = (Member)obj;
			members.put(m.getMemberId(), m);
		}
		
		if(members.containsKey(memberId))
			return members.get(memberId);
		
		return null;
	}

}
