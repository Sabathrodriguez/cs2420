package assign1;

import java.util.*;

public class PostfixCalculator {

    public static void main(String[] args) {
	// write your code here

        String testString1 = "1 2 3 * + 4 -";
        String testString2 = "1 + 3 * 4 - ( 2 + 5 )";

        System.out.println(evaluate(testString1
        ));

    }

    public static int evaluate(String str) throws RuntimeException {
        Stack<Integer> stack = new Stack<>();
        List<String> parsedString = new ArrayList<>(Arrays.asList(str.split(" ")));
        Iterator<String> parsedStringIterator = parsedString.iterator();

        try {
            while (parsedStringIterator.hasNext()) {
                String tempVal = parsedStringIterator.next();
                if (isOperand(tempVal)) {
                    Integer newPush = f_1(tempVal, stack);
                    stack.push(newPush);
                } else {
                    stack.push(Integer.parseInt(tempVal));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return stack.pop();
    }

    private static boolean isOperand(String input) {
        List<String> operators = new ArrayList<>(Arrays.asList("+","-","*","/","^"));

        return operators.contains(input);
    }

    private static int f_1(String operand, Stack<Integer> stack) {
        int val1 = 0;
        int val2 = 0;
        int answer = 0;
        switch (operand) {
            case "+":
                val1 = stack.pop();
                val2 = stack.pop();
                answer = val2+val1;
                break;
            case "-":
                val1 = stack.pop();
                val2 = stack.pop();
                answer = val2-val1;
                break;
            case "*":
                val1 = stack.pop();
                val2 = stack.pop();
                answer = val2*val1;
                break;
            case "/":
                val1 = stack.pop();
                val2 = stack.pop();
                answer = val2/val1;
                break;
            case "^":
                val1 = stack.pop();
                val2 = stack.pop();
                answer = val2^val1;
                break;
            default: answer = -1;

        }
        return answer;
    }
}
