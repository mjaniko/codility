package cracking.strings;


import java.util.Arrays;
import java.util.Comparator;

/**
 * NOTE: ASCII encodes 128 specified characters into seven-bit integers
 * NOTE: Extended ASCII encodes 256 specified characters into 8-bit integers
 */
public class StringUtil {

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     * what if u cannt use additional data structure
     * იდეა არის შემდეგი, უნდა გადავურბინოთ 1 ცალი ჩარიისთვის მასივის სხვა ელემენტებს და ვიპოვოთ თუ არის მსგავსი
     * <p>
     * TIME: O(N^2)
     */
    public boolean isUniqueBruteForce(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int k = i + 1; k < str.length(); k++) {
                if (str.charAt(i) == str.charAt(k)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * NOTE: მხოლოდ მუშაობს 128 ბიტიან ACII ელემენტებისთვის.
     * TIME: O(N) მაგრამ შეგვიძლია ვიდაოთ რადგან ჯამში 128 იტერაციას შეასრულებს და შესაბამისად O(1) იქნება მისი დრო
     */
    public boolean isUniqueForASCII(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }


    /**
     * ყველაზე ჩქარია მაგრამ ძაან რთულად გასაგები. BITWISE
     *
     * @param str
     * @return
     */
    public boolean isUniqueBitwise(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }


    /**
     * ვასორტირებთ სტრინგს
     *
     * @param s
     * @return
     */
    public String sortString(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public String sortStringManually(String str) {

        int MAX_CHAR = 26;
        int[] letters = new int[MAX_CHAR];

        for (char letter : str.toCharArray()) {
            letters[letter - 'a']++;
        }

        // Traverse the hash array and print
        // characters
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < MAX_CHAR; i++) {
            for (int j = 0; j < letters[i]; j++) {
                stringBuilder.append((char) (i + 'a'));
            }
        }

        return stringBuilder.toString();
    }

    /**
     * გადაჯგუფებით მიიღება თუ არა მსგავსი სიტყვა
     * ამოხსნა სორტირებით.
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isPermutation(String str1, String str2) {
        // ვამოწმებთ თუ ზომა ერთმანეთს არ უდრის ესეიგი არაა პერმუტაცია
        if (str1.length() != str2.length()) {
            return false;
        }
        return sortString(str1).equals(sortString(str2));
    }

    /**
     * პერმუტაცია ასკიზე, ვიცით ზომა
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isPermutationAscii(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] letters = new char[128];
        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            letters[str2.charAt(i)]--;
            if (letters[str2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public String sortStringComparator(String inputString) {
        // convert input string to Character array
        Character[] tempArray = new Character[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            tempArray[i] = inputString.charAt(i);
        }


        // Sort, ignoring case during sorting
        Arrays.sort(tempArray, new Comparator<Character>() {

            @Override
            public int compare(Character c1, Character c2) {
                // ignoring case
                return Character.compare(Character.toLowerCase(c1),
                        Character.toLowerCase(c2));
            }
        });

        // using StringBuilder to convert Character array to String
        StringBuilder sb = new StringBuilder(tempArray.length);
        for (Character c : tempArray)
            sb.append(c.charValue());

        return sb.toString();
    }

    public static void main(String[] args) {
        StringUtil str = new StringUtil();
        System.out.println("Is Unique:" + str.isUniqueBruteForce("aabbcc"));
        System.out.println("Is Unique:" + str.isUniqueForASCII("aabb"));
        System.out.println("Is Unique:" + str.isUniqueBitwise("AaBbc"));

        System.out.println("Is Permutation:" + str.isPermutation("ძაღლი", "ილღაძ"));
        System.out.println("Is Permutation:" + str.isPermutationAscii("dog", "god"));

        System.out.println("Sort:" + str.sortStringManually("cbadkls"));
        System.out.println("Sort:" + str.sortStringComparator("აგბდვ"));
    }

}
