package leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

    /**
     * Remove Duplicates without allocating extra array
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int nums[]) {
        if (nums.length == 0) return 0;
        int i = 0; // counter
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // swap sides and sort
            }
        }
        return i + 1;
    }


    public int[] removeDuplicates2(int nums[]) {
        if (nums.length == 0) throw new NullPointerException();

        // Sort if not sorted
        Arrays.sort(nums);

        int duplicates = 0; // counter var
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] == nums[j + 1]) {
                continue;
            }
            duplicates++;
        }

        int[] new_arr = new int[nums.length - duplicates];

        int k = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            if (nums[j] == nums[j + 1]) {
                continue;
            }
            new_arr[k++] = nums[j];
        }
        new_arr[k++] = nums[nums.length - 1];
        return new_arr;
    }


    public int removeDuplicates3(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                start++;
                nums[start] = nums[i];
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(new int[]{1, 1, 2, 3, 4, 4}));
        System.out.println(Arrays.toString(rd.removeDuplicates2(new int[]{1, 1, 2, 5, 3, 4, 4, 4, 3})));
        System.out.println(rd.removeDuplicates3(new int[]{1, 1, 2, 5, 3, 3, 4, 4}));
        System.out.println(rd.removeDuplicates3(new int[]{1, 1, 2}));
    }
}
