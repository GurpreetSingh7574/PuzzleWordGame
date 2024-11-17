public class WordList {
    public WordNode head;
    public WordNode tail;
    public int length;

    public WordList() {
        this.head = new WordNode(null);
        this.tail = this.head;
        this.length = 0;
    }

    public int getLength() {
        return this.length;
    }
    /**
     * appends the word to the end of the list
     * @param word the word to append
     */
    public void append(Word word) {
        WordNode newNode = new WordNode(word);
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }
    /**
     * add the word to the end
     * @param word the word to add
     */
    public void add(Word word) {
        this.append(word);
    }
    /**
     * 
     * @param word word to check for
     * @return true if the list contains the word
     */
    public boolean contains(Word word) {
        WordNode current = this.head.next;
        while (current != null) {
            if (current.data.compareTo(word) == 0) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}