package leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int INT_MAX = -1 >>> 1;
        if(x > INT_MAX) return false;

        if(x == 0) return true; // zero is palindrome num
        if(x < 0 || x % 10 == 0) return false;

        int reversedNumber = 0;
        while(x > reversedNumber){
            int reminder = x % 10;
            x /= 10;
            reversedNumber = (reversedNumber * 10) + reminder;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == reversedNumber || x == reversedNumber / 10 ;
    }
}
