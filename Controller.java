package FinalProject;

import java.awt.event.*;
import java.io.IOException;

public class Controller implements  ActionListener {
  // List the models and views that the controller interacts with
  private WordTester word;
  private GUI view;   
	
  public Controller(WordTester w, GUI v) {
    word = w;
    view = v;
    view.updateTotal();
		
    // add listeners to view
    view.addSubmitListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      // when the start button is pressed timer starts running
    	  String theWord = view.getWord();
    	  if(word.isInList(theWord)) {
    		  view.addWords(theWord);
    		  word.changeScore(theWord);
    		  view.updateScore();
    		  view.updateTotal();
    	  }
    	  else {
    		  view.notIn();
    		  
    	  }
    	  
      }
    });
    
    view.addNewSetListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if(view.gameCounter != 0) {
	        	try {
					word.changeLetters();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	view.newSet();
	        	view.wordCounter = 0;
        	}
        	
        	
      	  
        }
      });
			
  }
	
  public void actionPerformed(ActionEvent e) {
	 
  }
}
