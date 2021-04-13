package cracking.strings;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Chapter1 {

    public boolean isUniqueBruteForce(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int k = 0; k < s.length(); k++) {
                if (i == k) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(k)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUniqueBruteForceBetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int k = i + 1; k < s.length(); k++) {
                if (s.charAt(i) == s.charAt(k)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUniqueCharBool(String s) {
        boolean[] unique = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            if (unique[s.charAt(i)]) {
                return false;
            } else {
                unique[s.charAt(i)] = true;
            }
        }
        return true;
    }

    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int s1Weight = 0;
        int s2Weight = 0;
        for (int i = 0; i < s1.length(); i++) {
            s1Weight += s1.charAt(i);
            s2Weight += s2.charAt(i);
        }
        return s1Weight == s2Weight;
    }

    public boolean isPermutationBitwise(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            result ^= s1.charAt(i);
            result ^= s2.charAt(i);
        }
        return result == 0;
    }

    public String urlify(String input) {
        System.out.println("Input String:" + input);
        int spaceCount = 0;
        char[] inputArray = input.toCharArray();
        for (char elem : inputArray) {
            if (elem == ' ') {
                spaceCount++;
            }
        }
        int sizeOfNewString = input.toCharArray().length + spaceCount * 2;
        System.out.println("Space Count:" + spaceCount + " Old Array:" + input.toCharArray().length + " New Array:" + sizeOfNewString);
        char[] urlfy = new char[sizeOfNewString];
        int newArrayIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                urlfy[newArrayIndex] = '%';
                urlfy[newArrayIndex + 1] = '2'; // -1
                urlfy[newArrayIndex + 2] = '0'; // -2
                newArrayIndex += 3;
            } else {
                urlfy[newArrayIndex] = input.charAt(i);
                newArrayIndex++;
            }
        }
        return new String(urlfy);
    }

    /**
     * This is done with additional data structure
     *
     * @param phrase
     * @return
     */
    public boolean checkIfPermutationOfPalindrome(String phrase) {
        int count = 0; // we start from 1
        Hashtable<Character, Integer> table = new Hashtable<>();
        for (char c : phrase.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (table.get(c) == null) {
                count++;
                table.put(c, 1);
            } else {
                table.put(c, table.get(c) + 1);
                if (table.get(c) % 2 == 0) {
                    table.put(c, 0);
                    count--;
                }
            }
        }
        return count <= 1;
    }

    public boolean isPalindromePermutation(String str) {
        Map<Character, Integer> hashtable = new HashMap<>();
        int spaceCount = 0;
        for (char word : str.toCharArray()) {
            if (word == ' ') {
                spaceCount++;
                continue;
            }
            if (hashtable.get(word) != null) {
                hashtable.put(word, hashtable.get(word) + 1);
            } else {
                hashtable.put(word, 1);
            }
        }
        int trueWordCount = str.length() - spaceCount;
        for (Map.Entry<Character, Integer> data : hashtable.entrySet()) {
            if (data.getValue() % 2 == 0) {
                trueWordCount -= 2;
            }
        }
        return trueWordCount <= 1;
    }

    public boolean replace(String s1, String s2) {
        boolean replaced = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (replaced) {
                    return false;
                } else {
                    replaced = true;
                }
            }
        }
        return true;
    }

    public boolean insert(String big, String small) {
        boolean inserted = false;
        int index = 0;
        for (int i = 0; i < small.length(); i++) {
            if (big.charAt(index) != small.charAt(i)) {
                if (inserted) {
                    return false;
                } else {
                    inserted = true;
                    i--;
                }
            }
            index++;
        }
        return true;
    }

    public boolean oneWayCheck(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() == s2.length()) {
            return replace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return insert(s2, s1);
        } else if (s1.length() == s2.length() + 1) {
            return insert(s1, s2);
        }
        return false;
    }

    public String stringCompression(String s1) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            int j = i;
            int count = 0;
            while (j < s1.length()) {
                if (s1.charAt(j) == s1.charAt(i)) {
                    count++;
                } else {
                    break;
                }
                j++;
            }
            stringBuilder.append(s1.charAt(i));
            stringBuilder.append(count);
            i += count - 1;
        }
        return stringBuilder.toString();
    }

    public String compressBetter(String s1) {
        StringBuilder str = new StringBuilder();
        int countMatches = 0;
        for (int i = 0; i < s1.length(); i++) {
            countMatches++;
            if (i + 1 >= s1.length() || s1.charAt(i) != s1.charAt(i + 1)) {
                str.append(s1.charAt(i));
                str.append(countMatches);
                countMatches = 0;
            }
        }
        return str.toString();
    }


    public void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void nullifyMatrix(int[][] matrix) {
        printMatrix(matrix);

        boolean[] rowM = new boolean[matrix.length];
        boolean[] columnN = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowM[i] = true;
                    columnN[j] = true;
                }
            }
        }

        for (int i = 0; i < rowM.length; i++) {
            if (rowM[i]) {
                setZerosRow(matrix, i);
            }
        }

        for (int i = 0; i < columnN.length; i++) {
            if (columnN[i]) {
                setZeroColumn(matrix, i);
            }
        }
        printMatrix(matrix);
    }

    public void setZerosRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[row][i] = 0;
        }
    }

    public void setZeroColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[i][col] = 0;
        }
    }

    public void rotateMatrixClockWise(int[][] matrix) {
        int N = matrix.length - 1;
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = x; y < N - x; y++) {

                // Move right
                matrix[x][y] += matrix[y][N - x];
                matrix[y][N - x] = matrix[x][y] - matrix[y][N - x];
                matrix[x][y] -= matrix[y][N - x];


                // Move down
                matrix[x][y] += matrix[N - x][N - y];
                matrix[N - x][N - y] = matrix[x][y] - matrix[N - x][N - y];
                matrix[x][y] -= matrix[N - x][N - y];

                // Move Left
                matrix[x][y] += matrix[N - y][x];
                matrix[N - y][x] = matrix[x][y] - matrix[N - y][x];

                // Set Start  point | Move Up
                matrix[x][y] -= matrix[N - y][x];
            }
        }
        printMatrix(matrix);
    }

    public void rotateMatrixAntiClockWise(int[][] matrix) {
        int N = matrix.length - 1;
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = x; y < N - x; y++) {

                // Move Down
                matrix[x][y] += matrix[N - y][x];
                matrix[N - y][x] = matrix[x][y] - matrix[N - y][x];
                matrix[x][y] -= matrix[N - y][x];

                // Move Rights
                matrix[x][y] += matrix[N - x][N - y];
                matrix[N - x][N - y] = matrix[x][y] - matrix[N - x][N - y];
                matrix[x][y] -= matrix[N - x][N - y];

                // Move Up
                matrix[x][y] += matrix[N - y][N];
                matrix[N - y][N] = matrix[x][y] - matrix[N - y][N];

                // Set Start  point | Move Up
                matrix[x][y] -= matrix[N - y][N];
            }
        }
        printMatrix(matrix);
    }

    public void Matrix(int[][] matrix) {
        printMatrix(matrix);
        rotateMatrixClockWise(matrix);
        //rotateMatrixAntiClockWise(matrix);
    }

    public static void main(String[] args) {
        Chapter1 c1 = new Chapter1();
        //System.out.println(c1.isPalindromePermutation("miimsc"));
        c1.nullifyMatrix(new int[][]{
                {1, 0, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        //System.out.println(c1.isUniqueBruteForce("მიშო"));
        //System.out.println(c1.isUniqueBruteForce("მიიშო"));
        //System.out.println(c1.isUniqueBruteForceBetter("მიშო"));
        //System.out.println(c1.isUniqueCharBool("miisho"));
        System.out.println(c1.isPermutation("მიშო", "მიშო"));
        System.out.println(c1.isPermutationBitwise("მიშო", "მიშკ"));
        //System.out.println(c1.urlify("Mikheil Janiashvili"));
        //System.out.println(c1.checkIfPermutationOfPalindrome("tac coa"));
        //System.out.println(c1.oneWayCheck("pale", "ple"));
        //System.out.println(c1.oneWayCheck("pales", "pale"));
        //System.out.println(c1.oneWayCheck("pale", "bale"));
        //System.out.println(c1.oneWayCheck("pale", "bae"));
        //System.out.println(c1.stringCompression("aabcccccaaa"));
        //System.out.println(c1.compressBetter("aabcccccaaa"));
        /*c1.Matrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });*/
/*        c1.Matrix(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8,},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        });*/
    }
}
