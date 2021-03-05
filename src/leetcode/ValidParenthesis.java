package leetcode;

import java.util.Stack;

public class ValidParenthesis {

    private boolean isValid(String s) {
        Stack<Character> left_sides = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                left_sides.push(c); // ვყრით სტეკში
            } else {
                if (left_sides.isEmpty()) {
                    return false;
                }
                char curVal = left_sides.peek(); // ვიღებ
                if (c == ')' && curVal == '(' || c == '}' && curVal == '{' || c == ']' && curVal == '[') {
                    left_sides.pop(); // ვაგდებ
                } else {
                    return false;
                }
            }
        }
        return left_sides.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid("{}()[]"));
        System.out.println(vp.isValid("{([])}()[]"));
        System.out.println(vp.isValid("{[})"));
        System.out.println(vp.isValid("{}()[]"));
        System.out.println(vp.isValid("(])"));
    }
}
