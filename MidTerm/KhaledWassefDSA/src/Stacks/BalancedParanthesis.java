package Stacks;

import java.util.Stack;

public class BalancedParanthesis {


    static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatched(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }


    static boolean isMatched(char a, char b) {
        return (a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}');
    }

    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";


        boolean isBal = isBalanced(exp);
        System.out.println(isBal);
    }
}
