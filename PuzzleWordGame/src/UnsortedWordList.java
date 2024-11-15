public class UnsortedWordList extends WordList {
    public UnsortedWordList() { // constructs an empty unsorted word list
    	super();
    }
    /**
     * add a word to the end of the list
     * @param w the word to add
     */
    public void add(Word w) {
    	append(w);
    }
}