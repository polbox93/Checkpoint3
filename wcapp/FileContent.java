package wcapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class FileContent implements IterableText {

    String filename;
    ArrayList<String> fileContent;

    public FileContent(String filename) {
        this.filename = filename;
        this.fileContent = new ArrayList<>();


        Scanner scan = null;

        try {
            File file = new File(filename);
            scan = new Scanner(file);
            while(scan.hasNext()){
                String line = scan.nextLine().trim();
                if (!(line.isEmpty())){
                    this.fileContent.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(scan != null)
            scan.close();
        }
    }


    public Iterator<String> charIterator(){
        return new CharIterator(this);
    }

    public Iterator<String> wordIterator(){
        return new WordIterator(this);
    }

    public String getFileName(){
        return this.filename;
    }

}
