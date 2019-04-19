package mum.edu.domain;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class CheckoutFrame extends JFrame implements ActionListener{
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HIGHT = 250;
	private static int FRAME_X_ORIGIN = 250;
	private static int FRAME_Y_ORIGIN = 200;
	
	
	JLabel isbn;
	JTextField textnumber;
	JLabel title;
	JTextField bookTitle;
	JLabel author;
	JTextField authorName;
	JLabel ncopies;
	JTextField numberofcopiesbookField;
	
	
	JMenu homemenu, addmenu, checkotMenu;
	
	
	JComboBox<Book> combBooks;
	JTextField textfield;
	//JLabel lable;
	JButton searchbutton;

	Checkout checkout;
	
	public CheckoutFrame()
	{}	
	
	 public CheckoutFrame (Checkout checkout) {
		 this.checkout = checkout;
		 
		 Container contentPane;
		 setTitle("hfisjn  hi ic");
		 setSize(FRAME_WIDTH,FRAME_HIGHT);
		 setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
 		 setResizable(false);
		 
		 contentPane = getContentPane();
		 contentPane.setLayout(new FlowLayout());
		 
		 
		 isbn = new JLabel("book isbn:");
		 title = new JLabel("book title:");
		 textnumber = new JTextField(12);
		 textnumber = new JTextField(5);
		 searchbutton = new JButton("Add Meal Card");
		 searchbutton.addActionListener(this);
			
			contentPane.add(isbn);
			contentPane.add(textnumber);
			contentPane.add(title);
			contentPane.add(textnumber);
			contentPane.add(searchbutton);
		 
		 createaddmenu();
		 createcheckotMenu();
		 createhomemenu();
		
		 
		 
		 
		 
		 JMenuBar menubar = new JMenuBar();
		 setJMenuBar(menubar);
		 menubar.add(addmenu);
		 menubar.add(checkotMenu);
		 menubar.add(homemenu);
		 
		 combBooks = new JComboBox<Book>(checkout.getBooks().toArray(new Book[checkout.getBooks().size()]));
		 
		 searchbutton = new JButton("SEARCH");
		 searchbutton.addActionListener(this);
			
			contentPane.add(combBooks);
			contentPane.add(searchbutton);
		 
	 }
	 
	 private void createcheckotMenu() {
		// TODO Auto-generated method stub
		
	}

	private void createaddmenu() {
		// TODO Auto-generated method stub
		
	}

	private void createhomemenu() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		 CheckoutFrame ch = new CheckoutFrame();
		ch.setVisible(true);
		
		}
		
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Book book = (Book)combBooks.getSelectedItem();
		//Book book = (Book)cmbFoodItems.getSelectedItem();
		
		JOptionPane.showMessageDialog(this, 
				String.format("Purchase successful!, remaining balance: %d ", book.getNumberOfDays()));
		// TODO Auto-generated method stub
		
	}


	

}
