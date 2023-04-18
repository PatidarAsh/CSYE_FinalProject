package application.wordsearch;
import java.util.ArrayList;

public class WordList {
	
	// Stores the list of words to find
    private ArrayList<String> wordList = new ArrayList<String>(); 

    // Adds a word to wordList
    public void addWord(String word) {
        wordList.add(word);
    }

    public int getSize() {
        return wordList.size();
    }

   
    public String getValue(int pos) {
        return wordList.get(pos);
    }

    public void clearArrayList() {
        wordList.clear();
    }


    public boolean checkContains(String word) {
        return wordList.contains(word);
    }


    public void deleteWordListVal(int pos) {
        wordList.remove(pos);
    }
}