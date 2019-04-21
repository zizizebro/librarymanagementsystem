package edu.mum.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import edu.mum.ui.AllMembersFrame;
import edu.mum.ui.BookFrame;
import edu.mum.ui.CheckoutFrame;
import edu.mum.ui.MDIDesktopPane;
import edu.mum.ui.MemberFrame;
import edu.mum.ui.TextFrame;

public class Main extends JFrame {
	private MDIDesktopPane desktop = new MDIDesktopPane();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu addMenu = new JMenu("Add");
	private JMenuItem bookMenuItem = new JMenuItem("Book");
	private JMenuItem memeberMenuItem = new JMenuItem("Member");

	private JMenu checkoutMenu = new JMenu("Checkout");
	private JMenuItem checkoutMenuItem = new JMenuItem("Book");
	
	private JMenu searchMenu = new JMenu("Search");
	private JMenuItem searchBooktMenuItem = new JMenuItem("Book");
	private JMenuItem searchMemberMenuItem = new JMenuItem("Member");
	private JMenuItem searchCheckoutRecordtMenuItem = new JMenuItem("Checkout Record");
	
	private JMenu aboutMenu = new JMenu("About");
	private JMenuItem aboutMeMenuItem = new JMenuItem("About Me");
	
	
	private JScrollPane scrollPane = new JScrollPane();

	public Main() {
		menuBar.add(addMenu);
		menuBar.add(checkoutMenu);
		menuBar.add(searchMenu);
		menuBar.add(aboutMenu);
		
		addMenu.add(bookMenuItem);
		addMenu.addSeparator();
		addMenu.add(memeberMenuItem);
		
		checkoutMenu.add(checkoutMenuItem);
		
		searchMenu.add(searchBooktMenuItem);
		searchMenu.add(searchMemberMenuItem);
		searchMenu.addSeparator();
		searchMenu.add(searchCheckoutRecordtMenuItem);
		
		aboutMenu.add(aboutMeMenuItem);
		
		setJMenuBar(menuBar);
		setTitle("Library Management System");
		scrollPane.getViewport().add(desktop);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		bookMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				desktop.add(new BookFrame());
			}
		});
		
		memeberMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				desktop.add(new MemberFrame());
			}
		});

		checkoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				desktop.add(new CheckoutFrame());
			}
		});
		
		searchBooktMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				desktop.add(new TextFrame());
			}
		});
		
		searchMemberMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				desktop.add(new TextFrame());
			}
		});
		
		searchCheckoutRecordtMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				desktop.add(new AllMembersFrame());
			}
		});
		
		aboutMeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(desktop, "<html>Developed By:<br>Zinash Negga<br><a href='www.google.com'>negga149@gmail.com</a></html>", "About Me", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		

	}

	public static void main(String[] args) {
		
		Main mdi = new Main();
		mdi.setSize(800, 600);
		mdi.setVisible(true);
	}

}
