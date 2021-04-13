package hackerrank;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/grid-challenge/problem
 */
public class GridChallenge {

    public String gridChallenge(String[] grid) {
        char[][] matrix = new char[grid.length][grid[0].length()];
        int i = 0;
        for (String s : grid) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            for (int k = 0; k < charArr.length; k++) {
                matrix[i][k] = charArr[k];
            }
            i++;
        }
        System.out.println(Arrays.deepToString(matrix));

        // N^2
        int counter = 0;
        for (int k = 1; k < matrix.length; k++) {
            // row
            if (matrix[k - 1][counter] > matrix[k][counter]) {
                return "NO";
            }
            counter++;
        }
        return "YES";
    }

    public static void main(String[] args) {
        GridChallenge gc = new GridChallenge();
        System.out.println(gc.gridChallenge(new String[]{
                "ebacd",
                "fghij",
                "olmkn",
                "trpqs",
                "xywuv",
        }));


        System.out.println(gc.gridChallenge(new String[]{
                "abc",
                "lmp",
                "qrt",
        }));
    }
}
