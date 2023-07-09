package stringproblems;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String args[]) {
        String s = "(){}[]";
        boolean isValid = isValidParentheses(s);
        System.out.println(isValid);
    }

    private static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();//LIFO

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
