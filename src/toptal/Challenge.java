package toptal;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Challenge {

    /**
     * Worst Case
     *
     * @param series
     * @param target
     */
    private void printAllTripletsSumNaive(int[] series, int target) {
        for (int i = 0; i < series.length; i++) {
            for (int k = i + 1; k < series.length; k++) {
                for (int j = k + 1; j < series.length; j++) {
                    if (series[i] + series[j] + series[k] == target) {
                        System.out.println("(" + series[i] + "," + series[j] + "," + series[k] + ")");
                    }
                }
            }
        }
    }

    // 2, 7, 4, 9, 5, 1, 3 -> Sort
    // 1, 2, 3, 4, 5, 7, 9
    // ^, ^,             ^
    private void printAllTripletsSumSlidingWindow(int[] series, int target) {
        Arrays.sort(series);
        for (int i = 0; i < series.length - 2; i++) {
            int low = i + 1;
            int high = series.length - 1;
            while (low < high) {

                // Find Out
                if (series[i] + series[low] + series[high] > target) {
                    high--;
                } else {
                    low++;
                }

                // Print All Triplets
                if (series[i] + series[low] + series[high] == target) {
                    System.out.println("(" + series[i] + "," + series[low] + "," + series[high] + ")");
                }
            }
        }
    }


    /**
     * Devise a function that accepts an arbitrarly-nested array with elements
     * of arbitrary types, and returns a flattened version of it. Do not solve
     * the task using a built-in function that accomplish the whole task on Its
     * Own
     * INP: ["This is a string", 1, 2, [3], [4, [5, 6]], [[7]], 8, "[10,11]"]
     * OUT: ["This is a string",  1, 2, 3, 4, 5, 6, 7, 8, "[10, 11]"]
     *
     * @param objects
     * @return
     */
    private List<Object> flattenList(List<Object> objects) {
        List<Object> tempList = new ArrayList<>();
        for (Object o : objects) {
            if (o instanceof String || o instanceof Integer) {
                tempList.add(o);
            }
            if (o instanceof List) {
                tempList.addAll(this.flattenList((List<Object>) o));
            }
        }
        return tempList;
    }

    public static void main(String[] args) {
        Challenge c = new Challenge();
        c.printAllTripletsSumNaive(new int[]{2, 7, 4, 9, 5, 1, 3}, 10);
        System.out.println("X");
        c.printAllTripletsSumSlidingWindow(new int[]{2, 7, 4, 9, 5, 1, 3}, 10);

        List<Object> listOfInputs = new ArrayList<>();
        listOfInputs.add("This is a string");
        listOfInputs.add(1);
        listOfInputs.add(2);

        List<Object> tempArray = new ArrayList<>();
        tempArray.add(3);

        listOfInputs.add(tempArray);

        // [4, [5, 6]]
        List<Object> tempArray1 = new ArrayList<>();
        tempArray1.add(4);
        List<Object> tempArray2 = new ArrayList<>();
        tempArray2.add(5);
        tempArray2.add(6);
        tempArray1.add(tempArray2);

        listOfInputs.add(tempArray1);

        // [[7]]
        List<Object> tempArray3 = new ArrayList<>();
        List<Object> tempArray4 = new ArrayList<>();
        tempArray4.add(7);
        tempArray3.add(tempArray4);
        listOfInputs.add(tempArray3);

        listOfInputs.add(8);
        listOfInputs.add("[10, 11]");

        System.out.println("INP:" + listOfInputs.toString());
        List<Object> flatten = c.flattenList(listOfInputs);
        System.out.println("OUT:" + flatten.toString());


    }
}
