package leetcode;

import java.util.Arrays;

public class RemoveElement {



    // i ^ -> 0
    //   3, 2, 2, 3
    // j    ^ -> 1



    public int removeElement1(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }


    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
