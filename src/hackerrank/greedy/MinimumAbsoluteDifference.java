package hackerrank.greedy;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 */
public class MinimumAbsoluteDifference {

    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int target = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            target = Math.min(Math.abs(arr[i + 1] - arr[i]), target);
        }
        return target;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference mad = new MinimumAbsoluteDifference();
        System.out.println(mad.minimumAbsoluteDifference(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}));
        System.out.println(mad.minimumAbsoluteDifference(new int[]{1, -3, 71, 68, 17}));
    }
}
