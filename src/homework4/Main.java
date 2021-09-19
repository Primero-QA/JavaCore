package homework4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static ArrayList<String> myArray =
            new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four", "Five", "Two", "Three", "Four", "Five",
                    "Three", "Four", "Five", "Four", "Five", "Five"));

    public static void main(String[] args) {

        uniqueEntry();
        wordCount();
        Map.initEntries();
        Map.addEntries("Gagarin", 5436455);
        Map.showEntries("Ivanoff");


    }

    public static void wordCount() {
        String acc;
        HashSet<String> set = new HashSet<>(myArray);
        for (int i = 0; i < set.size(); i++) {
            acc = myArray.get(i);
            int count = 0;
            for (int j = 0; j < myArray.size(); j++) {
                if (acc == myArray.get(j)) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println(acc + ": " + count + " times");
            }
        }
    }

    public static void uniqueEntry() {
        HashSet<String> set = new HashSet<>(myArray);
        System.out.println(set);
    }

}
