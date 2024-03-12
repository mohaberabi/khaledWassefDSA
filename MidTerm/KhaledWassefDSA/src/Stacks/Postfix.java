package Stacks;

import java.util.Stack;

public class Postfix {


    static int presedence(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 1;
        }
    }


    static boolean isOperand(char c) {
        return Character.isLetter(c);
    }

    static boolean isLeft(char c) {
        return c == '(';
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*' || c == '^';
    }

    static boolean isRight(char c) {
        return c == ')';
    }

    static String postFix(String inrfix) {


        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : inrfix.toCharArray()) {
            if (isOperand(c)) {
                sb.append(c);
            } else if (isLeft(c)) {
                stack.push(c);
            } else if (isRight(c)) {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char popped = stack.pop();
                    if (isOperator(popped)) {
                        sb.append(popped);
                    }
                }
                stack.pop();

            } else if (isOperator(c)) {
                if (stack.isEmpty() || isLeft(stack.peek())) {
                    stack.push(c);
                } else if (presedence(c) > presedence(stack.peek())) {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && presedence(stack.peek()) >= presedence(c)) {
                        char pop = stack.pop();
                        sb.append(pop);
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            char pop = stack.pop();
            sb.append(pop);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String infix = "a+b*c+d";
        String post = postFix(infix);
        System.out.println(post);
    }
}
