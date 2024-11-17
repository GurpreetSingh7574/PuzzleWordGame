public class WordNode{
   public Word data;
   public WordNode next; // reference to next listNode
   /**
    * constructs a new word node with the specified word as its data
    * @param word the word object to store in the node
    */
   public WordNode(Word word)
   {
      this.data = word;
      this.next = null; 
   } 
}  
