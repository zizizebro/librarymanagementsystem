package edu.mum.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Address;
import mum.edu.domain.Author;
import mum.edu.domain.Book;
import mum.edu.domain.Member;

public class BookFrame extends JInternalFrame implements ActionListener {
	
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;  
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13; 
    JButton btn1, btn2;  
    
    public BookFrame() {
    	setVisible(true);  
        setSize(800, 550);  
        setLayout(null);   
        setClosable(true);
        setTitle("Add Book");  
        
        l1 = new JLabel("Book Information");  
        l1.setForeground(Color.black);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l15 = new JLabel("Author Information");  
        l15.setForeground(Color.black);  
        l15.setFont(new Font("Serif", Font.BOLD, 20));
        
        
        l2 = new JLabel("ISBN:");  
        l3 = new JLabel("Title:");  
        l4 = new JLabel("Number of Copies:");  
        l5 = new JLabel("Number of Days:"); 
        l6 = new JLabel("First Name:");  
        l7 = new JLabel("Last Name:");  
        l8 = new JLabel("Email:");  
        l9 = new JLabel("Phone Number:"); 
        l10 = new JLabel("Street:");  
        l11 = new JLabel("City:"); 
        l12 = new JLabel("State:"); 
        l13 = new JLabel("Zip Code:"); 
        l14 = new JLabel("Short Bio:"); 
        
        
        tf1 = new JTextField();  
        tf2 = new JTextField();  
        tf3 = new JTextField();   
        tf4 = new JTextField();  
        tf5 = new JTextField();  
        tf6 = new JTextField();  
        tf7 = new JTextField(); 
        tf8 = new JTextField(); 
        tf9 = new JTextField(); 
        tf10 = new JTextField(); 
        tf11 = new JTextField(); 
        tf12 = new JTextField(); 
        tf13 = new JTextField(); 
        
        btn1 = new JButton("Save");  
        btn2 = new JButton("Clear");  
        btn1.addActionListener(this);  
        btn2.addActionListener(this);  
        
        l1.setBounds(200, 30, 400, 30);
        l15.setBounds(500, 30, 400, 30);
        
        
        l2.setBounds(80, 70, 200, 30);  
        l3.setBounds(80, 110, 200, 30);  
        l4.setBounds(80, 150, 200, 30);  
        l5.setBounds(80, 190, 200, 30);
        
        l6.setBounds(450, 70, 200, 30);  
        l7.setBounds(450, 110, 200, 30);  
        l8.setBounds(450, 150, 200, 30); 
        l9.setBounds(450, 190, 200, 30); 
        l10.setBounds(450, 230, 200, 30); 
        l11.setBounds(450, 270, 200, 30); 
        l12.setBounds(450, 310, 200, 30); 
        l13.setBounds(450, 350, 200, 30); 
        l14.setBounds(450, 390, 200, 30); 
        
        tf1.setBounds(200, 70, 200, 30);  
        tf2.setBounds(200, 110, 200, 30);  
        tf3.setBounds(200, 150, 200, 30);  
        tf4.setBounds(200, 190, 200, 30); 
        
        tf5.setBounds(570, 70, 200, 30);  
        tf6.setBounds(570, 110, 200, 30);  
        tf7.setBounds(570, 150, 200, 30); 
        tf8.setBounds(570, 190, 200, 30); 
        tf9.setBounds(570, 230, 200, 30);
        tf10.setBounds(570, 270, 200, 30);
        tf11.setBounds(570, 310, 200, 30);
        tf12.setBounds(570, 350, 200, 30);
        tf13.setBounds(570, 390, 200, 30);
        
       
        
        btn1.setBounds(300, 430, 100, 30);  
        btn2.setBounds(410, 430, 100, 30); 
        
        add(l1);  
        add(l15);
        
        add(l2);  
        add(tf1);  
        add(l3);  
        add(tf2);  
        add(l4);  
        add(tf3);  
        add(l5);  
        add(tf4);  
        add(l6);  
        add(tf5);  
        add(l7);  
        add(tf6);  
        add(l8);  
        add(tf7); 
        add(l9);  
        add(tf8); 
        add(l10);  
        add(tf9); 
        add(l11);
        add(tf10); 
        add(l12);
        add(tf11); 
        add(l13);
        add(tf12); 
        add(l14);
        add(tf13); 
        add(btn1);  
        add(btn2);
    }
    
    public void actionPerformed(ActionEvent e)   
    {  
        if (e.getSource() == btn1)  
         { 
            Address address = new Address(tf9.getText(), tf10.getText(), tf11.getText(), tf12.getText());
            Author author = new Author(tf5.getText(), tf6.getText(), tf7.getText(), tf8.getText(), address, tf13.getText());
            
            List<Author> authors = new ArrayList<>();
            authors.add(author);
            
            Book book = new Book(tf1.getText(), tf2.getText(), Integer.parseInt(tf3.getText()), Long.parseLong(tf4.getText()), authors);
          
                try  
                {  
                	DataAccessFacde.saveObject(book);
                	JOptionPane.showMessageDialog(tf4, "Book and Author information saved successfully");   
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
         tf3.setText("");  
         tf4.setText("");  
         tf5.setText("");  
         tf6.setText("");  
         tf7.setText("");  
         tf8.setText("");  
         tf9.setText("");  
         tf10.setText("");  
         tf11.setText("");  
         tf12.setText("");  
         tf13.setText("");  
    }

}
