import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGame {
	
	private static PuzzleGUI puzzleGUI;
	private static SortedWordList sortedList;
	private static int score;
	
	/**
	 * resets the game by setting the score to 0 and updating the GUI
	 */
	private static void resetGame() {
		score = 0;
		puzzleGUI.updateScore(score);
		sortedList = new SortedWordList();
		puzzleGUI.updateFoundWordsArea(sortedList);
	}

    public static void main(String[] args) {
    	score = 0;
    	sortedList = new SortedWordList();
    	ArrayList<String> solutionsList = new ArrayList<>();
    	try {
            Scanner scanner = new Scanner(new File("P1input.txt"));
            while (scanner.hasNextLine()) {
            	try {
            		solutionsList.add(new Word(scanner.nextLine()).getWord());
            	} catch (IllegalWordException e) {
            		System.out.println("Illegal word in file: " + e.getMessage());
            	}
            }
            scanner.close();
            
            UnsortedWordList unsortedList = new UnsortedWordList();
            SortedWordList sortedList = new SortedWordList();
            
            for (String solution : solutionsList) {
            	unsortedList.add(new Word(solution));
            }
            
            String subjectLetters = getSubjectLetters(solutionsList);
            PuzzleGUI puzzleGUI = new PuzzleGUI(subjectLetters); 

            while (score < solutionsList.size()) { // loops until the score reaches the solution size
                String inputWord = JOptionPane.showInputDialog(null, "Enter a word:");
                if (inputWord == null) {
                    break;
                }
                String validationMessage = validateWord(inputWord, subjectLetters);
                if (validationMessage != null) {
                    JOptionPane.showMessageDialog(null, validationMessage);
                } else {
                	int points = 0; // points are 0 in the start
                	try {
                		Word word = new Word(inputWord);
                		if (unsortedList.contains(word)) {
                			if (containsAllLetters(inputWord, subjectLetters)) { // checks to see if the word has the subject letters
                				points = 3;
                			} else {
                	    		points = 1;
                			}
                	    }
                	} catch (IllegalWordException e) {
                		System.out.println("Illegal word: " + e.getMessage());
                	}

                	score += points; // update the score based on the points and points are gotten from if else statements
                    if (points > 0) {
                        sortedList.add(new Word(inputWord));
                        puzzleGUI.updateFoundWordsArea(sortedList);
                    }
                    puzzleGUI.updateScore(score);
                }
            }
            if (score == solutionsList.size()) {
                int playAgain = JOptionPane.showConfirmDialog(null, "Good Job, you have finished the game. Would you like to play again?" , "Play again?", JOptionPane.YES_NO_OPTION);
                if(playAgain == JOptionPane.YES_OPTION) {
                	resetGame();
                } else {
                	System.exit(0);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Wrong File " + e.getMessage());
        }
    }
    /**
     * 
     * @param solutionsList the list of solutions
     * @return a string containing the subject letters
     */
    private static String getSubjectLetters(ArrayList<String> solutionsList) {
    	StringBuilder sb = new StringBuilder();
    	for (String solution : solutionsList) {
    		for(char c: solution.toCharArray()) {
    			if (sb.indexOf(String.valueOf(c)) == -1){
    				sb.append(c);
    			}
    		}
    	}
    	 return sb.toString();
    }

	/**
     * checks if the word has all the letters
     * @param word the word to check
     * @param letters check the letters 
     * @return true if it has the letters
     */
    private static boolean containsAllLetters(String word, String letters) {
        for (char c : letters.toCharArray()) {
            if (word.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * validates the word 
     * @param inputWord the word to see if its correct
     * @param letters
     * @return the message
     */
    private static String validateWord(String inputWord, String letters) {
        if (inputWord.length() < 5) {
            return "Wrong, your word must be 5 letters.";
        }
        if(letters.indexOf(inputWord.charAt(0)) == -1) {
        	return "Wrong word, the first letter must be one of the subject letters.";
        }
        for (char c : inputWord.toCharArray()) {
            if (letters.indexOf(c) == -1) {
                return "Wrong word, use the Puzzle letters only.";
            }
        }
        return null;
    }
}