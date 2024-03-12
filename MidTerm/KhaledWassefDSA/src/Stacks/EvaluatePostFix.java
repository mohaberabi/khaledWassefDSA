package Stacks;

import java.util.Stack;

public class EvaluatePostFix {


    static double evalate(String a, String b, char operator) {

        return switch (operator) {
            case '+' -> Double.parseDouble(b) + Double.parseDouble(a);
            case '-' -> Double.parseDouble(b) - Double.parseDouble(a);
            case '/' -> Double.parseDouble(b) / Double.parseDouble(a);
            case '*' -> Double.parseDouble(b) * Double.parseDouble(a);
            default -> Math.pow(Double.parseDouble(b), Double.parseDouble(a));
        };
    }

    static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    static double evaluatePostFix(String postfix) {
        Stack<String> s = new Stack<>();

        String pure = postfix.trim().replaceAll(" ", "");

        for (char c : pure.toCharArray()) {

            if (isOperand(c)) {
                s.push(String.valueOf(c));
            } else {
                String op1 = String.valueOf(s.pop());
                String op2 = String.valueOf(s.pop());
                double eval = evalate(op1, op2, c);
                s.push(Double.toString(eval));
            }
        }

        return Double.parseDouble(s.peek());
    }


    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        String postFix = "2 3 1 * + 9 - ";
        double res = evaluatePostFix(postFix);
        System.out.println(res);
    }


}
