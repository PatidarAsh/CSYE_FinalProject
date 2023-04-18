package application.wordsearch;

import java.util.ArrayList;

public class WordSelected {
    //sort selected words in an arraylist
	private ArrayList<Character> wordSelect = new ArrayList<Character>();
    
	
    public void addLetter(char val) {
        wordSelect.add(val);
    }
    
    public int getSize() {
        return wordSelect.size();
    }

    public char getValue(int pos) {
        return wordSelect.get(pos);
    }

    public void clearArrayList() {
        wordSelect.clear();
    }

    public void removeValue(int pos) {
        wordSelect.remove(pos);
    }

    public void removeLastValue() {
        wordSelect.remove(wordSelect.size() - 1);
    }
    

}
