package leetcode;


import java.util.Arrays;

public class MinimumDeletionsToMake {

    public int solution(String s) {
        // ASCII Size
        int[] charMatrix = new int[128]; // zero

        for (char c : s.toCharArray()) {
            charMatrix[c]++;
        }

        int frequency = 0;
        int result = 0;
        for (int i = 0; i < charMatrix.length; i++) {
            if (charMatrix[i] > 0) {
                if (charMatrix[i] == frequency) {
                    result++;
                }
                frequency = Math.max(charMatrix[i], frequency);
            }
        }
        return result;
    }

    // A - 3
    // B - 4
    // C - 2
    public static void main(String[] args) {
        MinimumDeletionsToMake mdtm = new MinimumDeletionsToMake();
        System.out.println(mdtm.solution("aabbbcc"));
    }
}
