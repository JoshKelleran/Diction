package FinalProject;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.*;

import java.awt.event.*;


public class Main implements ActionListener {
	WordTester word;
	GUI gui;
	
	JFrame frame = new JFrame(); 
	JPanel panel = new JPanel();
	JButton myButton = new JButton("Launch Game");
	JButton btn = new JButton("Close");
	WordTester y;
	JLabel header = new JLabel("Diction Fiction");
	
	public Main() {
		frame.setContentPane(panel);
		
		header.setBounds(100, 100, 200, 40);
		header.setFont(new Font("Serif", Font.BOLD, 25));
		myButton.setBounds(50,160,150,40);
		myButton.setFocusable(false);
		myButton.addActionListener(this);
		  
		panel.add(myButton);
		panel.add(header);
		
		btn.setBounds(200,160,150,40);
		btn.setFocusable(false);
		btn.addActionListener(this); 
		panel.add(btn);
		panel.setBackground(Color.lightGray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420); 
		frame.setLayout(null);
		frame.setVisible(true);
		
	  
	 }
	
	 public void actionPerformed(ActionEvent e) {
	  
	  if(e.getSource()==myButton) {
		  frame.dispose();
		  try {
			run();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  }
	  if(e.getSource()==btn) {
		  frame.dispose();
	  }
	 }

	// creates instances of objects
	public void run() throws IOException{
		word = new WordTester();
		gui = new GUI(word);
		Controller ct = new Controller(word, gui);
	}
	public static void main(String[] args) throws IOException {
		
		Main x = new Main();
//		LaunchGame x = new LaunchGame(word, gui);
	}

}