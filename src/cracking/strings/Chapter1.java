package cracking.strings;

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

    public boolean isPermutation(String s1 , String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int s1Weight = 0;
        int s2Weight = 0;
        for(int i = 0; i < s1.length(); i++) {
            s1Weight += s1.charAt(i);
            s2Weight += s2.charAt(i);
        }
        return s1Weight == s2Weight;
    }

    public static void main(String[] args) {
        Chapter1 c1 = new Chapter1();
        System.out.println(c1.isUniqueBruteForce("მიშო"));
        System.out.println(c1.isUniqueBruteForce("მიიშო"));
        System.out.println(c1.isUniqueBruteForceBetter("მიშო"));
        System.out.println(c1.isUniqueCharBool("miisho"));
        System.out.println(c1.isPermutation("მიშო", "მიშო"));
    }
}
