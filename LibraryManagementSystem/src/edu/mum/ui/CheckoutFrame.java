package edu.mum.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Book;
import mum.edu.domain.Checkout;
import mum.edu.domain.Member;

public class CheckoutFrame extends JInternalFrame implements ActionListener {
	
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;  
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9; 
    JButton btn1, btn2;  
    //JPasswordField p1, p2; 
    
    public CheckoutFrame() {
    	setVisible(true);  
        setSize(500, 300);  
        setLayout(null);  
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        setClosable(true);
        
        setTitle("Book Checkout");  
        l1 = new JLabel("Book Checkout Form");  
        l1.setForeground(Color.black);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));  
        l2 = new JLabel("Book ISBN:");  
        l3 = new JLabel("Member ID:");  

        
        tf1 = new JTextField();  
        tf2 = new JTextField();  

        
        btn1 = new JButton("Checkout");  
        btn2 = new JButton("Clear");  
        btn1.addActionListener(this);  
        btn2.addActionListener(this);  
        
        l1.setBounds(100, 30, 400, 30);  
        l2.setBounds(80, 70, 200, 30);  
        l3.setBounds(80, 110, 200, 30);   
        
        tf1.setBounds(200, 70, 200, 30);  
        tf2.setBounds(200, 110, 200, 30);  

        
        btn1.setBounds(200, 150, 100, 30);  
        btn2.setBounds(300, 150, 100, 30);  
        add(l1);  
        add(l2);  
        add(tf1);  
        add(l3);  
        add(tf2);  
        add(btn1);  
        add(btn2);
    }
    
    public void actionPerformed(ActionEvent e)   
    {  
        if (e.getSource() == btn1)  
         { 
        	Book book = DataAccessFacde.getBook(tf1.getText());
        	System.out.println("book to be checkedout: " + book);
        	
        	Member member = DataAccessFacde.getMember(tf2.getText());
        	System.out.println("Member checking: " + member);
        	
        	List<Book> books = new ArrayList<>();
        	books.add(book);
        	
        	Checkout checkout = new Checkout(books, member, LocalDate.now(), LocalDate.now().plusDays(book.getNumberOfDays()));
        	member.addCheckoutRecord(checkout);
        	
        	System.out.println("CHECKOUT RECORD");
        	System.out.println("updated member info");
        	
//        	System.out.println("CHECKOUT RECORD: \n" + checkout);
//        	System.out.println("updated member info: \n" + member);
        	
        	
          
                try  
                {  
                	DataAccessFacde.saveObject(checkout);
                	DataAccessFacde.updateMemberCheckoutRecord(member);
                	JOptionPane.showMessageDialog(btn1, "Data Saved Successfully"); 
                	clearTextFields();
                }  
                catch (Exception ex)   
                {  
                    System.out.println(ex);  
                }    
          }   
          else  
          {  
        	  clearTextFields();
          }  
    } 
    
    private void clearTextFields() {
    	 tf1.setText("");  
         tf2.setText("");   
    }

}
