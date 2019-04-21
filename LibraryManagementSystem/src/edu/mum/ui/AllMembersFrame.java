package edu.mum.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Member;

public class AllMembersFrame extends JInternalFrame {

	private JTextArea textArea = new JTextArea();

	private JScrollPane scrollPane = new JScrollPane();

	public AllMembersFrame() {
	 setSize(200, 300);
	 setTitle("Copy Text");
	 setMaximizable(true);
	 setIconifiable(true);
	 setClosable(true);
	 setResizable(true);
	 
//	 final JFrame frame = new JFrame("JTable Demo");
	 
//     String[] columns = {"Code", "Name", "High", "Low",
//                         "Close", "Volume", "Change","Change %"};

//     Object[][] data = {
//         {"MBF", "CITYGROUP", 10.16, 10.16, 10.16, 200, 0.08,0.79},
//         {"MBL", "BANK OF AMERICA", 12.66, 12.66, 12.66, 6600, 0.13,1.04},
//         {"MJP", "Morgan Stanley Dean Witter & Co.", 24.97, 24.97, 24.97, 1000, -0.04,-0.16}
//     };
     
	 
	 String[] columns = {"Member ID", "Name"};

     DataAccessFacde.setFileName("Member");
     List<Member> members = DataAccessFacde.getFileContents();
     Object[] mems = members.toArray();
     System.out.println(Arrays.toString(mems));
     
     Object[][] data = new Object[members.size()][1];
     for ( int i = 0; i < mems.length; i++ ){
    	 Object[] m = new Object[]{((Member)mems[i]).getMemberId(), ((Member)mems[i]).getMemberId() };
    	 System.out.println("NEW ARRAY CREATED: " + Arrays.toString(m));
         data[i][0] = m;
     }
  

     JTable table = new JTable(data, columns);
//     JScrollPane scrollPane = new JScrollPane(table);
     table.setFillsViewportHeight(true);

     JLabel lblHeading = new JLabel("Stock Quotes");
     lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));

//     frame.getContentPane().setLayout(new BorderLayout());
//
//     frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
//     frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
//
//     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     frame.setSize(550, 200);
//     frame.setVisible(true);
     
     scrollPane.getViewport().add(table);
//     scrollPane.getViewport().add(textArea);
	 getContentPane().setLayout(new BorderLayout());
	 getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
