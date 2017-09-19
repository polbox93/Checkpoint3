package wcapp;

import java.util.LinkedList;
import java.util.Iterator;



public class Application {


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Application app = new Application();
        View view = new View();

        app.start(view, args);

        long endTime = System.currentTimeMillis();

        Float time = ((endTime - startTime)/1000.0f);

        view.printString("Procede time: " + time + " sec.");
    }

    public void start(View view, String... args) {
        for (String filename : args) {
            FileContent fc = new FileContent(filename);
            this.textAnalyser(fc, view);
        }
    }

    public void textAnalyser(FileContent fc, View view) {
        view.printString("==" + fc.getFileName() + "==");

        StatisticalAnalysis charSA = new StatisticalAnalysis(fc.charIterator());
        StatisticalAnalysis wordSA = new StatisticalAnalysis(fc.wordIterator());

        view.printString("Char count: " + charSA.size());
        view.printString("Word count: " + wordSA.size());
        view.printString("Dict size: " + wordSA.dictionarySize());

        view.printString("Most used words (>1%): " + wordSA.mostUsedWords());

        view.printString("'love' count:" + wordSA.countOf("love"));
        view.printString("'hate' count: " + wordSA.countOf("hate"));
        view.printString("'music' count: " + wordSA.countOf("music"));

        view.printString("vowels %: " + charSA.vovelsPercentage());

        view.printString("a:e count ratio: " + charSA.a_eRatio());

        charSA.lettersInText(view);
        view.printSpace();




    }


}
