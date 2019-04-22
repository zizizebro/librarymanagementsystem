package edu.mum.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.mum.dao.DataAccessFacde;
import mum.edu.domain.Address;
import mum.edu.domain.Member;

public class MemberFrame extends JInternalFrame implements ActionListener {
	
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;  
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9; 
    JButton btn1, btn2; 
    
    public MemberFrame() {
    	setVisible(true);  
        setSize(700, 550);  
        setLayout(null);    
        setClosable(true);
        
        setTitle("Add Member");  
        l1 = new JLabel("Member Registration Form");  
        l1.setForeground(Color.black);  
        l1.setFont(new Font("Serif", Font.BOLD, 20));  
        l2 = new JLabel("Member ID:");  
        l3 = new JLabel("First Name:");  
        l4 = new JLabel("Last Name:");  
        l5 = new JLabel("Email:");  
        l6 = new JLabel("Phone Number:");  
        l7 = new JLabel("Street:");  
        l8 = new JLabel("City:"); 
        l9 = new JLabel("State:"); 
        l10 = new JLabel("Zip Code:"); 
        
        tf1 = new JTextField();  
        tf2 = new JTextField();  
        tf3 = new JTextField();   
        tf4 = new JTextField();  
        tf5 = new JTextField();  
        tf6 = new JTextField();  
        tf7 = new JTextField(); 
        tf8 = new JTextField(); 
        tf9 = new JTextField(); 
        
        btn1 = new JButton("Save");  
        btn2 = new JButton("Clear");  
        btn1.addActionListener(this);  
        btn2.addActionListener(this);  
        
        l1.setBounds(100, 30, 400, 30);  
        l2.setBounds(80, 70, 200, 30);  
        l3.setBounds(80, 110, 200, 30);  
        l4.setBounds(80, 150, 200, 30);  
        l5.setBounds(80, 190, 200, 30);  
        l6.setBounds(80, 230, 200, 30);  
        l7.setBounds(80, 270, 200, 30);  
        l8.setBounds(80, 310, 200, 30); 
        l9.setBounds(80, 350, 200, 30); 
        l10.setBounds(80, 390, 200, 30); 
        
        tf1.setBounds(200, 70, 200, 30);  
        tf2.setBounds(200, 110, 200, 30);  
        tf3.setBounds(200, 150, 200, 30);  
        tf4.setBounds(200, 190, 200, 30);  
        tf5.setBounds(200, 230, 200, 30);  
        tf6.setBounds(200, 270, 200, 30);  
        tf7.setBounds(200, 310, 200, 30); 
        tf8.setBounds(200, 350, 200, 30); 
        tf9.setBounds(200, 390, 200, 30); 
        
        btn1.setBounds(200, 430, 100, 30);  
        btn2.setBounds(300, 430, 100, 30);  
        add(l1);  
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
        add(btn1);  
        add(btn2);
    }
    
    public void actionPerformed(ActionEvent e)   
    {  
        if (e.getSource() == btn1)  
         { 
            String id = tf1.getText();  
            String firstName = tf2.getText();   
            String lastName = tf3.getText();   
            String email = tf4.getText();   
            String phoneNumber = tf5.getText();  
            String street = tf6.getText();  
            String city = tf7.getText(); 
            String state = tf8.getText(); 
            String zipcode = tf9.getText(); 
            
            Address address = new Address(street, city, state, zipcode);
            Member member = new Member(id, firstName, lastName, email, phoneNumber, address);
          
                try  
                {  
                	DataAccessFacde.saveObject(member);
                	JOptionPane.showMessageDialog(tf5, "Member information saved successfully"); 
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
    }

}
