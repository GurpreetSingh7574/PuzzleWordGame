# Word Puzzle Game

A word puzzle game built in Java that allows users to load a list of solutions from a file, display a set of subject letters, and track the user's found words and score.
This project uses a linked list structure to store words and ensures that the guessed words meet specific criteria.

## Features

- **File Handling**: The game can load puzzle data from a text file and display subject letters.
- **Word Validation**: Ensures that only valid words are added to the puzzle.
- **Linked List Data Structure**: Uses a custom linked list (`WordList`) to store and manage words.
- **Dynamic GUI**: Displays the subject letters, found words, and score in an intuitive graphical user interface (GUI).
- **Score Calculation**: Words that contain all subject letters are worth 3 points, and users can see their current score.

## Project Structure

### `WordPuzzleGame.java`
Main entry point of the game that sets up the GUI and handles the game logic.

### `PuzzleGUI.java`
GUI class that displays the user interface for the game, including the subject letters, found words, and score.

### `WordList.java`
A custom linked list implementation to store `Word` objects. It includes methods for appending words, checking for word existence, and getting the list length.

### `WordNode.java`
Represents a single node in the linked list, containing a `Word` object and a reference to the next node.

### `Word.java`
The `Word` class encapsulates the word data, performs validation, and implements comparison logic.

### `IllegalWordException.java`
Custom exception thrown when an invalid word is encountered.

### `FileMenuHandler.java`
Handles file menu actions (open and quit) in the GUI.

## Setup

### Prerequisites

- Java 8 or later
- An IDE such as IntelliJ IDEA, Eclipse, or any Java-compatible IDE

### Steps to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/word-puzzle-game.git
