import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
//action listener for actions in file menu 
public class FileMenuHandler implements ActionListener {
	private PuzzleGUI puzzleGUI;
	

	public FileMenuHandler(PuzzleGUI puzzleGUI) {
		this.puzzleGUI = puzzleGUI;
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Open")) {
			//handle open option
			JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                	//read file 
                    Scanner scanner = new Scanner(new File(filePath));
                    ArrayList<String> solutionsList = new ArrayList<>();
                    while (scanner.hasNextLine()) {
                        try {
                            solutionsList.add(new Word(scanner.nextLine()).getWord());
                        } catch (IllegalWordException ex) {
                            System.out.println("Illegal word in file: " + ex.getMessage());
                        }
                    }
                    scanner.close();
                    
                    UnsortedWordList unsortedList = new UnsortedWordList();
                    SortedWordList sortedList = new SortedWordList();
                    int score = 0;
                    puzzleGUI.updateScore(score);
                    
                    for (String solution : solutionsList) {
                        unsortedList.add(new Word(solution));
                    }
                    String subjectLetters = getSubjectLetters(solutionsList);
                    puzzleGUI.puzzleLettersLabel.setText("Subject Letters: " + subjectLetters);
                    puzzleGUI.updateFoundWordsArea(sortedList);

                } catch (FileNotFoundException ex) {
                    System.err.println("File not found: " + ex.getMessage());
                }
            }
        } else if (command.equals("Quit")) {
            System.exit(0);
            //handles the quit action
        }
	}
	/**
	 * 
	 * @param solutionsList the list of solutions
	 * @return a string containing the subject letters
	 */
	private String getSubjectLetters(ArrayList<String> solutionsList) {
        StringBuilder sb = new StringBuilder();
        for (String solution : solutionsList) {
            for (char c : solution.toCharArray()) {
                if (sb.indexOf(String.valueOf(c)) == -1) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
	}
}
	
