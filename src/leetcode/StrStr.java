package leetcode;

public class StrStr {

    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty()) return 0;
        if (needle.isEmpty()) return 0;

        int i;
        for (i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                break;
            }
        }

        if (i + needle.length() > haystack.length()) return -1;
        if (haystack.substring(i, i + needle.length()).equals(needle)) {
            return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();

        System.out.println(strStr.strStr("hello", "ll"));
    }
}
