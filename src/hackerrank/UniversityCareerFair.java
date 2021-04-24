package hackerrank;

import java.util.Arrays;

public class UniversityCareerFair {

    int solution(int[] arrival, int[] duration) {
        int[][] interval = new int[arrival.length][2];

        for (int i = 0; i < arrival.length; i++) {
            interval[i] = new int[]{arrival[i], arrival[i] + duration[i]};
        }

        System.out.println(Arrays.deepToString(interval));
        Arrays.sort(interval, (a, b) -> a[1] - b[1]);
        System.out.println(Arrays.deepToString(interval));
        return 0;
    }

    public static void main(String[] args) {
        UniversityCareerFair s = new UniversityCareerFair();
        s.solution(new int[]{1, 3, 3, 5, 7}, new int[]{2, 2, 1, 2, 1});
    }
}
