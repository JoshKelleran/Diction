package FinalProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;


import javax.swing.*;

import java.awt.*;


//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JTextField;
//import javax.swing.JPanel;
//import javax.swing.JTextArea;

// create new customer text box


public class GUI {
	private JTextArea textArea;
	private JTextField words;
	JButton submit;	
	JButton newSet;	
	JLabel lettersLabel;
	JLabel score;
	JLabel notInList;
	JLabel total;
	int wordCounter =0;
	int gameCounter;
	JLabel gCounter;    
	WordTester word;
	
	public GUI(WordTester x) {
		submit = new JButton("Submit");
		newSet = new JButton("New Set");
		words = new JTextField(""); 
		
		word = x;
		gameCounter = 2;
		
		gCounter = new JLabel("Sets Remaining : " + gameCounter);
		JFrame window = new JFrame();
		@SuppressWarnings("unused")
		String letters = word.getLetters();
		
	    // create a panel that uses BorderLayout
	    JPanel mainPanel = new JPanel();
	    mainPanel.setLayout(new BorderLayout());
	    JPanel top = new JPanel();
	    top.setLayout(new FlowLayout()); top.setBackground(Color.lightGray);
	    
	    JPanel panel1 = new JPanel(); 
	    JPanel panel2 = new JPanel(); panel2.setBackground(Color.lightGray);
	    JPanel panel3 = new JPanel(); panel3.setBackground(Color.lightGray);
	    JPanel center = new JPanel(new BorderLayout()); center.setBackground(Color.orange);
	    JPanel centerSouth = new JPanel(new FlowLayout()); centerSouth.setBackground(Color.orange);
	    score = new JLabel("Your Score is: " + word.getScore());
	    score.setFont(new Font("Serif", Font.BOLD, 16));
	    words.setBackground(Color.orange);
	    
	    
	    gCounter.setFont(new Font("Serif", Font.BOLD, 16));
	    
	    
	    panel3.setLayout(new BorderLayout());
	    
	    textArea = new JTextArea(1,12); 	 
	    textArea.setFont(new Font("Serif", Font.BOLD, 25));
	    words.setFont(new Font("Serif", Font.BOLD, 18));
	    
	    // add the label if the submitted word is not in the list
	    notInList = new JLabel("");
	    notInList.setFont(new Font("Serif", Font.BOLD, 20));
	    panel3.add(notInList, BorderLayout.WEST);
	    
	    total = new JLabel("");
		total.setText("Possible words to create: " + wordCounter + "/" + (word.getListOfWords().size() + wordCounter));

	    total.setFont(new Font("Serif", Font.BOLD, 20));
	    
	    
	    window.setContentPane(mainPanel);
	    mainPanel.add(top, BorderLayout.NORTH);
	  
	    
	    lettersLabel = new JLabel("Your letters are: " + word.getLetters());
	    lettersLabel.setFont(new Font("Serif", Font.BOLD, 20));
	    
	    top.add(score);
	    top.add(panel1);
	    top.add(panel2);
	    center.add(centerSouth, BorderLayout.SOUTH);
	    centerSouth.add(textArea);
	    centerSouth.add(submit);
	    center.add(words);
	    
	    mainPanel.add(panel3, BorderLayout.SOUTH);
	    mainPanel.add(center, BorderLayout.CENTER);
	    
	    //panel3.add(textArea2, BorderLayout.WEST);

	    panel1.setBorder(BorderFactory.createLineBorder(Color.black));
	    //panel2.setBorder(BorderFactory.createLineBorder(Color.black));
	    textArea.setBorder(BorderFactory.createLineBorder(Color.black));
	    //textArea2.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    //JLabel label = new JLabel 
	    		//System.out.println("Your Letters are: " + letters);
	    
	    panel1.add(lettersLabel);
	    
	    panel2.add(newSet);
	    panel2.add(gCounter);
	    
	    JPanel panel6 = new JPanel();
	    panel6.setBackground(Color.lightGray);
	    panel3.add(panel6, BorderLayout.EAST);
	    
	    panel6.setLayout(new BorderLayout());
	    
	    total.setBackground(Color.lightGray);
	    panel6.add(total);
	      
	    window.setSize(800,600);
	    window.setTitle("Diction Fiction");
	    window.setVisible(true);	
	}
	
	public void addSubmitListener(ActionListener listener) {
        submit.addActionListener(listener);
    }
	
	public void addNewSetListener(ActionListener listener) {
        newSet.addActionListener(listener);
    }
	
    public String getWord() {
    	return textArea.getText().toUpperCase();
    }
    
    public void notIn() {
    	notInList.setText(getWord() + " is not an accepted word");
    	textArea.setText(null);
    }
	
    public void addWords(String x) {
    	wordCounter++;
    	if (words.getSelectedText() != "") words.setText(words.getText() + " \n" + getWord());
    	else words.setText(x);
    	textArea.setText(null);
    	notInList.setText("");
    }
    
    public void updateScore() {
    	score.setText("Your Score is: " + word.getScore());
    }
    
    public void updateTotal() {
		total.setText("Possible words to create: " + wordCounter + "/" + (word.getListOfWords().size() + wordCounter));
    }
    
    public void newSet() {
  
		//word.getLetters();
		lettersLabel.setText("Your letters are: " + word.getLetters());
		gameCounter= gameCounter - 1;
		gCounter.setText("Sets Remaining: " + gameCounter);
		wordCounter = 0;
		total.setText("Possible words to create: " + wordCounter + "/" + (word.getListOfWords().size() + wordCounter));
    	//gCounter.setText("No More Sets Remaining");
    		
    }
    
	public static void main(String[] args) {
		//GUI x = new GUI();
	}
		
}

