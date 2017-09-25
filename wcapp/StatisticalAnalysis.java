package wcapp;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashSet;
import java.math.BigDecimal;



public class StatisticalAnalysis {

    Map<String, Integer> map = new HashMap<>();
    int totalSize = 0;

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.map = new HashMap<>();

        while (iterator.hasNext()) {
            String elem = iterator.next().toLowerCase();
            totalSize ++;

            if (map.containsKey(elem)){
                map.put(elem, map.get(elem)+1);
            } else {
                map.put(elem, 1);
            }
        }
    }


    public int countOf(String... elems){
        int counter = 0;
        for (String elem : elems){
            if (this.map.containsKey(elem)) {
                counter += map.get(elem);
            }
        }
        return counter;
    }


    public int dictionarySize(){
        return map.size();
    }


    public int size(){
        return this.totalSize;
    }


    public HashSet<String> ocurMoreThan(int times) {

        HashSet <String> result = new HashSet<>();

        for (String key : this.map.keySet()){
            if (this.map.get(key) > times) {
                result.add(key);
            }
        }
        return result;
    }
}
