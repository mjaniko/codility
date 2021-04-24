package hackerrank;

public class Panagrams {

    /**
     * ASCII format
     * @param s
     * @return
     */
    public String solution(String s) {
        // Write your code here
        char[] map = new char[128];
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == ' ') continue;
            map[c]++;
        }

        for (int i = 97; i <= 97 + 26; i++) {
            if (map[i] < 0) {
                return "not pangram";
            }
        }
        return "pangram";
    }

    public static void main(String[] args) {
        Panagrams pa = new Panagrams();
        pa.solution("We promptly judged antique ivory buckles for the prize");
    }
}
