public class SortedWordList extends WordList {
    public SortedWordList() { // creates an empty sorted word list
    	super();
    }
    /**
     * adds the word to the list in sorted order
     * @param word the word to add
     */
    public void add(Word word) {
        WordNode current = this.head;
        while (current.next != null && current.next.data.compareTo(word) < 0) {
            current = current.next;
        }

        WordNode newNode = new WordNode(word);
        newNode.next = current.next;
        current.next = newNode;
        this.length++;

        if (newNode.next == null) {
            this.tail = newNode;
        }
    }
}