package hackerrank;

import java.util.Arrays;

public class MaximumSum {

    public int solution(int[] arr) {
        Arrays.sort(arr);
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum += arr[i];
            currentSum = Math.max(arr[i], currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSum ms = new MaximumSum();
        System.out.println(ms.solution(new int[]{1, 3, 4, 5}));
        System.out.println(ms.solution(new int[]{-1, -2, 1, 3}));
        System.out.println(ms.solution(new int[]{1, 3, 4, -2, 5, -7}));
        // -7, -2, 1, 3, 4, 5
        // 1 3 4 5
    }
}
