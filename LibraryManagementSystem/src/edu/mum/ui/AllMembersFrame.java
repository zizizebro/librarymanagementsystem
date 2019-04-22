package edu.mum.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Member;
import mum.edu.domain.Person;

@SuppressWarnings("serial")
public class AllMembersFrame extends JInternalFrame {

	private JScrollPane scrollPane = new JScrollPane();

	public AllMembersFrame() {
	 setSize(700, 400);
	 setTitle("Members List");
	 setMaximizable(true);
	 setIconifiable(true);
	 setClosable(true);
	 setResizable(true);   
	 
     DataAccessFacde.setFileName("Member");
	 List<Member> membersList = DataAccessFacde.getFileContents();

	    String[] columns = {"Member ID", "First Name", "Last Name", "Email", "Phone", "Address"};
	    
	    String[][] data = new String[membersList.size()][columns.length];
	    int i = 0;
	    for (Member  member: membersList) {
	        String[] memberData = new String[columns.length];
	        
	        memberData[0] = member.getMemberId();
	        memberData[1] = member.getFirstName();
	        memberData[2] = member.getLastName();
	        memberData[3] = member.getEmail();
	        memberData[4] = member.getPhoneNumber();
	        memberData[5] = member.getAddress().getStreet() + ", " + member.getAddress().getCity() + ", " +
	        				member.getAddress().getState() + " " + member.getAddress().getZip();

	        data[i++] = memberData;
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
