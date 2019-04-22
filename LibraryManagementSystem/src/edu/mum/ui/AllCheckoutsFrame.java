package edu.mum.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Book;
import mum.edu.domain.Checkout;

@SuppressWarnings("serial")
public class AllCheckoutsFrame extends JInternalFrame {

	private JScrollPane scrollPane = new JScrollPane();

	public AllCheckoutsFrame() {
	 setSize(700, 400);
	 setTitle("Checkout History");
	 setMaximizable(true);
	 setIconifiable(true);
	 setClosable(true);
	 setResizable(true);   
	 
     DataAccessFacde.setFileName("Checkout");
	 List<Checkout> checkoutList = DataAccessFacde.getFileContents();
	 checkoutList.remove(0);

	    String[] columns = {"Member Id", "Checkout Date", "Due Date", "Books"};
	    
	    String[][] data = new String[checkoutList.size()][columns.length];
	    int i = 0;
	    for (Checkout  checkout: checkoutList) {
	        String[] checkoutData = new String[columns.length];
	        
	        checkoutData[0] = checkout.getMember().getMemberId();
	        checkoutData[1] = checkout.getCheckoutDate().toString();
	        checkoutData[2] = checkout.getDueDate().toString();
	        checkoutData[3] = checkout.getBooks().get(0).getTitle();

	        data[i++] = checkoutData;
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
