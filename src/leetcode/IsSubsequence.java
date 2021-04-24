package leetcode;

public class IsSubsequence {

    /**
     * https://leetcode.com/problems/is-subsequence/submissions/
     *
     * @param s
     * @param t
     * @return
     */
    public boolean solution(String s, String t) {
        // s = "aec", t = "abcde" - FALSE
        // s = "ace", t = "abcde" - TRUE

        // s = "abc", t = "ahabgdc" - TRUE
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return j == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.solution("b", "abc"));
    }

}
