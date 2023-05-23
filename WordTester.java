package FinalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WordTester {
	String letters;
	ArrayList<String> listOfWords;
	int score = 0;
	
	public static void main(String[] args) throws IOException {
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Enter pool of letters");
		WordTester x = new WordTester();
		System.out.println(x.letters);
		System.out.println(x.listOfWords);
		//scan.close();
	}
	// constructor
	public WordTester() throws IOException{
		letters = createRandomString(8);//scan.nextLine().toUpperCase();
		listOfWords = createListOfAcceptedWords(letters);
		System.out.println(listOfWords);
	}
	
	// returns letters
	public String getLetters() {
		return letters;
	}
	
	// changes group of letters
	public void changeLetters() throws IOException {
		letters = createRandomString(8);
		listOfWords = createListOfAcceptedWords(letters);
		
		System.out.println(listOfWords);
	}
	
	// gets score
	public int getScore() {
		return score;
	}
	
	// gets list of words
	public ArrayList<String> getListOfWords() {
		return listOfWords;
	}
	
	// changes the score
	public void changeScore(String x) {
		score += (x.length() * 100);
	}
	
	// checks whether the word is in the list
	public boolean isInList(String word) {
		for (int i=0; i < listOfWords.size(); i++) {
			if(word.equals(listOfWords.get(i))) {
				listOfWords.remove(i);
				return true;
			}
		}
		return false;
	}
	
	// creates random set of letters
	public static String createRandomString(int amount) {
		String text = "aabcdeefghiijklmnoopqrstuuvwxyz"; //two of vowels to increase likelihood 
		Random random = new Random();

         
        String list = "";
        for(int i=0; i < amount; i++) {
        	int select = random.nextInt(text.length());
        	list += (text.charAt(select));
        }
        return list.toUpperCase();
        //System.out.println("Random char selected: " + text.charAt(select));  
	}
	
	// creates a list of the words that would work
	public static ArrayList<String> createListOfAcceptedWords(String letters) throws IOException {
		ArrayList<String> listOfAcceptedWords = new ArrayList<String>();
		
		
		Map<Character, Integer> letterMap = getCharCountMap(letters);
		BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
			//"/Users/joshkelleran/OneDrive/COLLEGEJUNIOR/COEN 160/CD_contents/CD_contents/Contents/JavaBook/src/FinalProject/dictionary.txt"));
		
		System.out.println("All possible combinations");
		// for loop to find all available words in dictionary file
		for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
			Map<Character, Integer> currentMap = getCharCountMap(currentWord);
			
			boolean canMakeWord = true;
			for(Character character : currentMap.keySet()) {
				
				int currentCharCount = currentMap.get(character);
				
				int lettersCharCount;
				if(letterMap.containsKey(character)) lettersCharCount = letterMap.get(character);
				else lettersCharCount = 0;
				
				if (currentCharCount > lettersCharCount) {
					canMakeWord = false;
					break;
				}	
			}
			// if it can make the word add it to a list
			if(canMakeWord) {
				//System.out.println(currentWord);
				listOfAcceptedWords.add(currentWord);
			}
			
		}
		reader.close();
		return listOfAcceptedWords;
		
	}
	
	// find the number of letters for each letter in alphabet -> how many c's do I have? call getCharCountMap();
	public static Map<Character, Integer> getCharCountMap(String letters) {
		Map<Character, Integer> letterMap = new HashMap<>();
		
		char current;
		int count;
		for(int i=0; i < letters.length(); i++) {
			current = letters.charAt(i);
			
			if(letterMap.containsKey(current)) count = letterMap.get(current);
			else count = 0;
			
			letterMap.put(current, count + 1);
		}
		return letterMap;
	}
	
}