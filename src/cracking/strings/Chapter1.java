package cracking.strings;

import java.util.Hashtable;
import java.util.Map;

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

    public static void main(String[] args) {
        Chapter1 c1 = new Chapter1();
        //System.out.println(c1.isUniqueBruteForce("მიშო"));
        //System.out.println(c1.isUniqueBruteForce("მიიშო"));
        //System.out.println(c1.isUniqueBruteForceBetter("მიშო"));
        //System.out.println(c1.isUniqueCharBool("miisho"));
        //System.out.println(c1.isPermutation("მიშო", "მიშო"));
        System.out.println(c1.urlify("Mikheil Janiashvili"));
        System.out.println(c1.checkIfPermutationOfPalindrome("tac coa"));
    }
}
