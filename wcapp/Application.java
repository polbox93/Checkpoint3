package wcapp;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.math.BigDecimal;



public class Application {

    private final static View view = new View();


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Application app = new Application();

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

        view.printString("Most used words (>1%): " + mostUsedWords(wordSA));

        view.printString("'love' count:" + wordSA.countOf("love"));
        view.printString("'hate' count: " + wordSA.countOf("hate"));
        view.printString("'music' count: " + wordSA.countOf("music"));

        view.printString("vowels %: " + vovelsPercentage(charSA));

        view.printString("a:e count ratio: " + a_eRatio(charSA));

        lettersInText(charSA);
        view.printSpace();

    }


    public static HashSet<String> mostUsedWords(StatisticalAnalysis wordSA){
        HashSet <String> result = new HashSet<>();

        result = wordSA.ocurMoreThan(wordSA.size() / 100);

        return result;
    }


    public static Float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }


    public static Float vovelsPercentage(StatisticalAnalysis charSA){
        Float quantity = (charSA.countOf("a", "o", "e", "i", "u") /
                            (float) charSA.size() * 100.0f);

        return round(quantity, 2);
    }


    public static Float a_eRatio(StatisticalAnalysis charSA){
        Float ratio = charSA.countOf("a") / (float) charSA.countOf("e") * 100;

        return round(ratio, 2);
    }


    public static void lettersInText(StatisticalAnalysis charSA){
        char c = 'a';
        while (c <= 'z'){
            Float percentInText = charSA.countOf(String.valueOf(c)) /
                                    (float) charSA.size() * 100;
            view.printStringInOneLine(c, percentInText);
            c++;
        }
    }
}
