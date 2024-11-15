import javax.swing.*;
import java.awt.*;


/**
 * A class for the GUI of the puzzle game
 */
public class PuzzleGUI {
	// text and label area for found words and score
    private JTextArea foundWordsArea;
    private JLabel scoreLabel;
    public JLabel puzzleLettersLabel;




    public PuzzleGUI(String subjectLetters) {
    	//creates the pop up window names it Word game
    	JFrame frame = new JFrame("WORD GAME"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows us to click x and close out

        JPanel panel = new JPanel(new GridLayout(1, 2)); // creates a grid layout with 1 row of 2 columns

        // Creates a left panel with displaying the puzzle letters
        JPanel leftPanel = new JPanel(new BorderLayout());
        puzzleLettersLabel = new JLabel("Subject Letters: " + subjectLetters);
        puzzleLettersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leftPanel.add(puzzleLettersLabel, BorderLayout.CENTER);

        // creates a right panel with found words area 
        JPanel rightPanel = new JPanel(new BorderLayout());
        foundWordsArea = new JTextArea(10, 20);
        foundWordsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(foundWordsArea);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // Score label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightPanel.add(scoreLabel, BorderLayout.SOUTH);

        // Add left and right panels to the main panel
        panel.add(leftPanel);
        panel.add(rightPanel);
        
        // add a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        //have options, open or quit
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        
        fileMenu.add(openMenuItem);
        fileMenu.add(quitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        
        FileMenuHandler fileMenuHandler = new FileMenuHandler(this);
        
        openMenuItem.addActionListener(fileMenuHandler);
        quitMenuItem.addActionListener(fileMenuHandler);
      
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    /**
     * updates the found words area
     * @param sortedList the sorted list of the words
     */
    public void updateFoundWordsArea(WordList sortedList) {
    	StringBuilder sb = new StringBuilder();
    	WordNode current = sortedList.head.next;
    	while (current != null) {
    		sb.append(current.data.getWord()).append("\n");
    		current = current.next;
    	}
    	foundWordsArea.setText(sb.toString());
    }
    /**
     * update the score label with the input score
     * @param score The score to display
     */
    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score); // Update the score JLabel
    }
}
