package application;

import java.util.Random;

import application.wordsearch.WordList;


public class Base {


    private WordList wordList = new WordList(); // Hold the list of words that the user still needs to find
//    private WordSelected wordSelect = new WordSelected(); // Holds a list of selected characters
    private char[][] matrix; // Becomes the matrix, and is initialized with a size from WordSearch.java
    private int matrixSize; // Holds the size of the board
    private String input = new String(); // Stores the word that the user selects
    private int oldRow = -1; // Set to the row of the first letter of wordSelect
    private int oldCol = -1; // Set to the column of the first letter of wordSelect
    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Conatins all possible random letters
    
    private final int sizeEazy = 15, sizeMedium = 20, sizeHard = 25;
    private final int wordEazy = 4, wordMedium = 8, wordHard = 12;

    final static String[] wordLibrary = { "HAPPY", "MOTIVATED", "CONFIDENT", "POSITIVE", "ENERGETIC", 
    		"PERSISTENT", "DISCIPLINED", "PROACTIVE", "GRACIOUS", "HONEST", "RELIABLE", "RESPECTFUL", 
    		"HUMBLE", "GRATEFUL", "ADAPTABLE", "EMPATHETIC", "DILIGENT", "VISIONARY", "CHARISMATIC", 
    		"MINDFUL", "RELIABLE", "BALANCED", "OPTIMISTIC", "KIND", "ENGAGED", "DRIVEN", "COURAGEOUS",
    		"GENUINE", "HUMBLE", "EMPOWERED"}; // Library of words that are possible to be hidden
    
    
    /**
     * Starts the game board with the size depending on difficulty selected.
     * 
     * @param difficulty Difficulty setting chosen by user, used to set matrix
     *                   and wordList size
     */
    public void initmatrix(Main.Difficulty difficulty) {
        switch (difficulty) {
        case EASY:
            matrixSize = sizeEazy;
            generateWords(wordEazy); // Sets wordList to 4 random words
            startmatrix(matrixSize); // Starts matrix with size of 15x15
            break;
        case MEDIUM:
            matrixSize = sizeMedium;
            generateWords(wordMedium); // Sets wordList to 8 random words
            startmatrix(matrixSize); // Starts matrix with size of 20x20
            break;
        case HARD:
            matrixSize = sizeHard;
            generateWords(wordHard); // Sets wordList to 12 random words
            startmatrix(matrixSize); // Starts matrix with size of 25x25
            break;
        }
        populatematrix(); // Places the words on the board
        fillBlanks(); // Randomizes unfilled positions to a random Char
        // printmatrix();
    }
    /**
     * Initializes the matrix
     * 
     * @param size Sets the 2d array size as sizeXsize (e.g a 15x15 grid)
     */
    public void startmatrix(int size) {
        matrix = new char[size][size];
    }
    
    
    /**
     * Places the words in wordList in the board. Runs checks so that all positions
     * are valid and not overwriting another word
     */
    public void populatematrix() {
        Random rand = new Random(); // Random value generator
        int modifier; // Changes the location that is currently being written to
        int orientation, randCol, randRow; // These store the values of the orientaion, the column of the first letter,
                                           // and the row of the first letter respectively
        boolean added = false; // Stores whether ir not a given word has been added

        for (int i = 0; i < wordList.getSize(); i++) {
            do {
                added = false;
                orientation = rand.nextInt(4);
                randRow = rand.nextInt(matrixSize);
                randCol = rand.nextInt(matrixSize);
                if (preventOutOfBound(matrix, orientation, randRow, randCol, wordList.getValue(i).length())) {
                    if (preventOverlap(matrix, orientation, randRow, randCol, wordList.getValue(i).length())) {
                        for (int j = 0; j < wordList.getValue(i).length(); j++) {
                            modifier = j; // Increments the position that is currently being written to
                            switch (orientation) {
                            case 0: // If orientation is verical up
                                matrix[randRow - modifier][randCol] = wordList.getValue(i).charAt(modifier);
                                break;
                            case 1: // If orientation is horizontal right
                                matrix[randRow][randCol + modifier] = wordList.getValue(i).charAt(modifier);
                                break;
                            case 2: // If orientation is verical down
                                matrix[randRow + modifier][randCol] = wordList.getValue(i).charAt(modifier);
                                break;
                            case 3: // If orientation is horizontal left
                                matrix[randRow][randCol - modifier] = wordList.getValue(i).charAt(modifier);
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
     * Returns the character at a given position in the matrix
     */
    public char getBoardPos(int row, int col) {
        return matrix[row][col];
    }
    
    public void generateWords(int count) {
        Random rand = new Random();
        wordList.clearArrayList(); // Clears the word list
        int wordsAdded = 0; // Tracks how many words have been added already
        while (wordsAdded < count) {
            int randomVal = rand.nextInt(wordLibrary.length);

            if (!wordList.checkContains(wordLibrary[randomVal])) { // If word isn't in wordList yet
                wordList.addWord(wordLibrary[randomVal]);
                wordsAdded++;
            }
        }
    }
    
    public boolean preventOutOfBound(char[][] matrix, int orientation, int row, int col, int length) {
        boolean inbounds = false;

        switch (orientation) {
        case 0:
            if ((row + 1) - length >= 0) {
                inbounds = true;
            }
            break;
        case 1:
            if (col + length <= matrixSize) {
                inbounds = true;
            }
            break;
        case 2:
            if ((row - 1) + length < matrixSize) {
                inbounds = true;
            }
            break;
        case 3:
            if ((col + 1) - length >= 0) {
                inbounds = true;
            }
        }

        return inbounds;
    }

    
    public boolean preventOverlap(char[][] matrix, int orientation, int row, int col, int length) {
        boolean checker = true;
        int modifier;

        for (int i = 0; i < length; i++) {
            modifier = i;
            switch (orientation) {
            case 0:
                if (matrix[row - modifier][col] != 0) {
                    checker = false;
                }
                break;
            case 1:
                if (matrix[row][col + modifier] != 0) {
                    checker = false;
                }
                break;
            case 2:
                if (matrix[row + modifier][col] != 0) {
                    checker = false;
                }
                break;
            case 3:
                if (matrix[row][col - modifier] != 0) {
                    checker = false;
                }
                break;
            }
        }
        return checker;
    }
    
    public void fillBlanks() {
        Random randChar = new Random(); // Random value generator
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = ALPHABET.charAt(randChar.nextInt(ALPHABET.length()));
                }
            }
        }
    }
    
    public String getInput() {
        return input;
    }

}
