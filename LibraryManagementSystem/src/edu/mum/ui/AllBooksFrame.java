package edu.mum.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Book;
import mum.edu.domain.Member;
import mum.edu.domain.Person;

@SuppressWarnings("serial")
public class AllBooksFrame extends JInternalFrame {

	private JScrollPane scrollPane = new JScrollPane();

	public AllBooksFrame() {
	 setSize(700, 400);
	 setTitle("Books List");
	 setMaximizable(true);
	 setIconifiable(true);
	 setClosable(true);
	 setResizable(true);   
	 
     DataAccessFacde.setFileName("Book");
	 List<Book> bookList = DataAccessFacde.getFileContents();

	    String[] columns = {"ISBN", "Title", "No Copies", "Borrow Days", "Authors"};
	    
	    String[][] data = new String[bookList.size()][columns.length];
	    int i = 0;
	    for (Book  book: bookList) {
	        String[] bookData = new String[columns.length];
	        
	        bookData[0] = book.getIsbn();
	        bookData[1] = book.getTitle();
	        bookData[2] = "" + book.getNumberOfCopies();
	        bookData[3] = "" + book.getNumberOfDays();
	        bookData[4] = book.getAuthor().get(0).getFirstName() + " " + book.getAuthor().get(0).getLastName();

	        data[i++] = bookData;
	    }

     JTable table = new JTable(data, columns);
     table.setFillsViewportHeight(true);
     table.setAutoCreateRowSorter(true);
     table.setShowGrid(true);
     table.setGridColor(Color.PINK);
            
     scrollPane.getViewport().add(table);
	 getContentPane().setLayout(new BorderLayout());
	 getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
