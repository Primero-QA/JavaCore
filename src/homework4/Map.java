package homework4;

import java.util.HashMap;

public class Map {

   private static HashMap<Integer, String> myList = new HashMap<>();

    public static void initEntries() {
       myList.put(22334455, "Ivanoff");
       myList.put(33334755, "Sidoroff");
       myList.put(22334665, "Ivanoff");
       myList.put(22654455, "Petroff");
       myList.put(22785467, "Baranoff");
       myList.put(25643433, "Demidoff");
       myList.put(21354758, "Smirnoff");
       myList.put(23337455, "Kozloff");
       myList.put(25384885, "Ivanoff");
       myList.put(23333435, "Ivanoff");
       myList.put(22677455, "Demidoff");
   }

   public static void addEntries(String s, int number) {
       myList.put(number, s);
   }

   public static void showEntries(String name) {
        for (int n : myList.keySet()) {
            if (name == myList.get(n)) {
                System.out.println(myList.get(n) + " - " + n);
            }
        }
   }
}
