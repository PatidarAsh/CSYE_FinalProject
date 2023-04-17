package application;

import java.util.Random;

import application.wordsearch.WordList;


public class Base {


    private WordList wordList = new WordList(); // Hold the list of words that the user still needs to find
//    private WordSelected wordSelect = new WordSelected(); // Holds a list of selected characters
    private char[][] gameBoard; // Becomes the gameBoard, and is initialized with a size from WordSearch.java
    private int boardSize; // Holds the size of the board
    private String wordIn = new String(); // Stores the word that the user selects
    private int oldRow = -1; // Set to the row of the first letter of wordSelect
    private int oldCol = -1; // Set to the column of the first letter of wordSelect
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Conatins all possible random letters
    
    private final int EASY_BOARD_SIZE = 15;
    private final int MEDIUM_BOARD_SIZE = 20;
    private final int HARD_BOARD_SIZE = 25;
    private final int EASY_WORD_SIZE = 4;
    private final int MEDIUM_WORD_SIZE = 8;
    private final int HARD_WORD_SIZE = 12;

    final static String[] WORD_LIBRARY = { "COMPUTER", "UTAS", "JAVA", "INFORMATION", "COMMUNICATION", "TECHNOLOGY",
            "PROGRAMMING", "CLASS", "FUNCTION", "INTERNET", "LAPTOP", "DESKTOP", "PROCESSOR", "SERVER", "INTEGER",
            "FLOAT", "BOOLEAN", "WINDOWS", "APPLE", "SOFTWARE", "HARDWARE", "SECURITY", "LECTURE", "TUTORIAL", "PASS",
            "LINUX", "GOOGLE", "FACEBOOK", "LINKEDIN", "METHOD", "BROWSER", "APPLICATION", "DATA", "DEVELOPMENT",
            "ETHICS", "VULNERABILITY", "SYSTEM" }; // Library of words that are possible to be hidden
    
    
    /**
     * Starts the game board with the size depending on difficulty selected.
     * 
     * @param difficulty Difficulty setting chosen by user, used to set gameboard
     *                   and wordList size
     */
    public void initGameBoard(Main.Difficulty difficulty) {
        switch (difficulty) {
        case EASY:
            boardSize = EASY_BOARD_SIZE;
            randomizeWordList(EASY_WORD_SIZE); // Sets wordList to 4 random words
            startGameBoard(boardSize); // Starts gameboard with size of 15x15
            break;
        case MEDIUM:
            boardSize = MEDIUM_BOARD_SIZE;
            randomizeWordList(MEDIUM_WORD_SIZE); // Sets wordList to 8 random words
            startGameBoard(boardSize); // Starts gameboard with size of 20x20
            break;
        case HARD:
            boardSize = HARD_BOARD_SIZE;
            randomizeWordList(HARD_WORD_SIZE); // Sets wordList to 12 random words
            startGameBoard(boardSize); // Starts gameboard with size of 25x25
            break;
        }
        populateGameBoard(); // Places the words on the board
        fillGameBoard(); // Randomizes unfilled positions to a random Char
        // printGameBoard();
    }
    /**
     * Initializes the gameBoard
     * 
     * @param size Sets the 2d array size as sizeXsize (e.g a 15x15 grid)
     */
    public void startGameBoard(int size) {
        gameBoard = new char[size][size];
    }
    
    
    /**
     * Places the words in wordList in the board. Runs checks so that all positions
     * are valid and not overwriting another word
     */
    public void populateGameBoard() {
        Random rand = new Random(); // Random value generator
        int modifier; // Changes the location that is currently being written to
        int orientation, randCol, randRow; // These store the values of the orientaion, the column of the first letter,
                                           // and the row of the first letter respectively
        boolean added = false; // Stores whether ir not a given word has been added

        for (int i = 0; i < wordList.getSize(); i++) {
            do {
                added = false;
                orientation = rand.nextInt(4);
                randRow = rand.nextInt(boardSize);
                randCol = rand.nextInt(boardSize);
                if (checkInBounds(gameBoard, orientation, randRow, randCol, wordList.getValue(i).length())) {
                    if (checkForOverwrite(gameBoard, orientation, randRow, randCol, wordList.getValue(i).length())) {
                        for (int j = 0; j < wordList.getValue(i).length(); j++) {
                            modifier = j; // Increments the position that is currently being written to
                            switch (orientation) {
                            case 0: // If orientation is verical up
                                gameBoard[randRow - modifier][randCol] = wordList.getValue(i).charAt(modifier);
                                break;
                            case 1: // If orientation is horizontal right
                                gameBoard[randRow][randCol + modifier] = wordList.getValue(i).charAt(modifier);
                                break;
                            case 2: // If orientation is verical down
                                gameBoard[randRow + modifier][randCol] = wordList.getValue(i).charAt(modifier);
                                break;
                            case 3: // If orientation is horizontal left
                                gameBoard[randRow][randCol - modifier] = wordList.getValue(i).charAt(modifier);
                                break;
                            }
                            added = true;
                        }
                    }
                }
            } while (!added); // Loop until word is added
        }
    }

    /**
     * Returns the character at a given position in the gameBoard
     */
    public char getBoardPos(int row, int col) {
        return gameBoard[row][col];
    }

}
