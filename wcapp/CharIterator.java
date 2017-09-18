package wcapp;

import java.util.LinkedList;
import java.util.Iterator;



public class CharIterator implements Iterator <String>{


    LinkedList<String> letters;

    public CharIterator(FileContent fc) {
        this.letters = new LinkedList<String>();

        for (String line : fc.fileContent){
            String[] wordsLine = line.split("\\s+");
            for (String word : wordsLine){
                for (int i = 0; i < word.length(); i++){
                    char c = word.charAt(i);
                    String s = String.valueOf(c).toLowerCase();
                    this.letters.add(s);
                }
            }
        }
    }


    public boolean hasNext(){
        return this.letters.size() > 0;
    }

    public String next(){
        return this.letters.pollFirst();
    }


}
