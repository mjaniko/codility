package lesson2;

import java.util.HashMap;
import java.util.Map;

/**
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 * Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, pu
 */
public class OddOccurrencesInArray {

    /**
     * Time Complexity: O(N) or O(N*log(N))
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (pairs.containsKey(A[i])) {
                pairs.put(A[i], pairs.get(A[i]) + 1);
            } else {
                pairs.put(A[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> elem : pairs.entrySet()) {
            if (elem.getValue() % 2 != 0) {
                return elem.getKey();
            }
        }
        return 0;
    }

    /**
     * Time Complexity: O(N)
     * Using the concept of "XOR" (^)
     * when there is a pair A and B
     * A^B will be zero
     * A^B^C (where C is not paired),
     * then A^B^C = C
     *
     * @param A
     * @return
     */
    public int solution2(int[] A) {
        if (A.length == 0)
            return 0;
        int unpaired = A[0];
        for (int i = 1; i < A.length; i++) {
            unpaired = unpaired ^ A[i];
        }
        return unpaired;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray odc = new OddOccurrencesInArray();
        int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};
        System.out.println(odc.solution(A));
        System.out.println(odc.solution2(A));
    }
}
