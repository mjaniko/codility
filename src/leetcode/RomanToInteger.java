package leetcode;


public class RomanToInteger {

    int romanToInt(String str1) {
        int sum = 0;
        for (int i = 0; i < str1.length(); i++) {
            switch (str1.charAt(i)) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    if (i != 0 && str1.charAt(i - 1) == 'I') {
                        sum += 3;
                    } else {
                        sum += 5;
                    }
                    break;
                case 'X':
                    if (i != 0 && str1.charAt(i - 1) == 'I') {
                        sum += 8;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    if (i != 0 && str1.charAt(i - 1) == 'X') {
                        sum += 30;
                    } else {
                        sum += 50;
                    }
                    break;
                case 'C':
                    if (i != 0 && str1.charAt(i - 1) == 'X') {
                        sum += 80;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    if (i != 0 && str1.charAt(i - 1) == 'C') {
                        sum += 300;
                    } else {
                        sum += 500;
                    }
                    break;
                case 'M':
                    if (i != 0 && str1.charAt(i - 1) == 'C') {
                        sum += 800;
                    } else {
                        sum += 1000;
                    }
                    break;
            }
        }
        return sum;
    }

    int romanToIntV2(String s){
        int[] b = new int[26];

        b['I'-'A'] = 1;
        b['V'-'A'] = 5;
        b['X'-'A'] = 10;
        b['L'-'A'] = 50;
        b['C'-'A'] = 100;
        b['D'-'A'] = 500;
        b['M'-'A'] = 1000;
        int temp = 0;
        int count = 0;
        char[] str = s.toCharArray();
        for (int i = str.length-1; i >= 0; i--) {
            int a = b[str[i]-'A'];

            if(a < temp){
                count -= a;
            }else{
                count = count + a;
            }
            temp = a;

        }
        return count;
    }
    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("XVVVVVVVVVVVVV"));
        System.out.println(rti.romanToIntV2("XVVVVVVVVVVVVV"));
    }
}
