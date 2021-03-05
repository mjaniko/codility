package leetcode;

public class ReverseInteger {

    public int reverse(int x) {
        int reverse_num = 0;
        while (x != 0) {
            int reminder = x % 10;
            x /= 10;
            int result = (reverse_num * 10) + reminder;
            // Constraint
            if (reverse_num >= (-1 >>> 1) || reverse_num <= (1 << 31)) return 0;
            if((result - reminder) / 10 != reverse_num) return 0;
            reverse_num = result;
        }
        return reverse_num;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1534236469));
    }
}
