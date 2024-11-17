
/**
 * Represents a word object that can be compared to other words.
 */
public class Word implements Comparable<Word> {
    private String word;

    /**
     * @param word the string form of the word
     */
    public Word(String word) {
    	for (char c: word.toCharArray()) {
    		if(!Character.isLowerCase(c)) {
    			throw new IllegalWordException("Word must contain only lowercase letters: " + word);
    		}
    	}
    	this.word = word;
    }
    /**
     * @return the string representation of the word
     */
    public String getWord() {
        return word;
    }
    /**
     * @param other the other word that is to compare
     */
    public int compareTo(Word other) {
        return this.word.compareTo(other.word);
    }
}

