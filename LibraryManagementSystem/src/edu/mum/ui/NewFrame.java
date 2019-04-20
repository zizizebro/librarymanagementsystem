package edu.mum.ui;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NewFrame extends JInternalFrame {

	private JTextArea textArea = new JTextArea();

	private JScrollPane scrollPane = new JScrollPane();

	public NewFrame() {
	 setSize(200, 300);
	 setTitle("Copy Text");
	 setMaximizable(true);
	 setIconifiable(true);
	 setClosable(true);
	 setResizable(true);
	 scrollPane.getViewport().add(textArea);
	 getContentPane().setLayout(new BorderLayout());
	 getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
