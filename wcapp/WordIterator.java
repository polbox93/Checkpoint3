package wcapp;

import java.util.LinkedList;
import java.util.Iterator;



public class WordIterator implements Iterator <String> {


    LinkedList<String> words;

    public WordIterator(FileContent fc) {
        this.words = new LinkedList<String>();

        for(String line : fc.fileContent){
            String[] wordsLine = line.split("\\s+");
            for (String word : wordsLine){
                this.words.add(word);
            }
        }
    }


    public boolean hasNext(){
        return this.words.size() > 0;
    }

    public String next(){
        return this.words.pollFirst();
    }


}
