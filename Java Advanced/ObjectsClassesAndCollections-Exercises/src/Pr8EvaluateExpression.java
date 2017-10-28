import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Pr8EvaluateExpression {
    public static void main(String[] args) throws IOException {

        Deque<Operator1> operator1s = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().split("\\s+");
        for (int i = 0; i < line.length; i++) {
            try {
                int parsed = Integer.parseInt(line[i]);
                stringBuilder.append(parsed);
                stringBuilder.append(" ");
            } catch (NumberFormatException e) {
                Operator1 opr = new Operator1(line[i]);
                if (line[i].equals("(")) {
                    operator1s.push(opr);
                } else if (line[i].equals(")")) {
                    Operator1 popped = operator1s.pop();
                    while (!popped.getValue().equals("(")) {
                        stringBuilder.append(popped.getValue());
                        stringBuilder.append(" ");
                        popped = operator1s.pop();
                    }
                } else {
                    while (!operator1s.isEmpty() && operator1s.peek().getPrecedence() >= opr.getPrecedence()) {
                        stringBuilder.append(operator1s.pop().getValue());
                        stringBuilder.append(" ");
                    }
                    operator1s.push(opr);
                }
            }
        }
        while (true) {
            stringBuilder.append(operator1s.pop().getValue());
            if (operator1s.isEmpty()) {
                break;
            }
            stringBuilder.append(" ");
        }
        Deque<String> stack = new ArrayDeque<>();
        List<String> split = Arrays.stream(stringBuilder.toString().split("\\s+")).collect(Collectors.toList());
        Collections.reverse(split);
        for (String s : split) {
            stack.push(s);
        }
        Deque<Double> numbers = new ArrayDeque<>();
        while (stack.size() >= 1) {
            String current = stack.pop();
            try {
                double num = Double.parseDouble(current);
                numbers.push(num);
            } catch (NumberFormatException e) {
                double num1 = numbers.pop();
                double num2 = numbers.pop();
                double result = calculateResult(num1, num2, current);
                numbers.push(result);
            }
        }
        System.out.println(String.format("%.2f", numbers.pop()));
    }

    private static double calculateResult(double num1, double num2, String current) {
        double result = 0D;
        switch (current) {
            case "+":
                result = num1 + num2;
                break;
            case  "-":
                result = num2 - num1;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = Math.max(num1, num2) / Math.min(num1, num2);
                break;
        }
        return result;
    }
}

class Operator1 {
    String value;
    int precedence;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPrecedence() {
        return precedence;
    }

    public Operator1(String value) {
        this.value = value;
        switch (value) {
            case "+":
                this.precedence = 2;
                break;
            case "-":
                this.precedence = 2;
                break;
            case "*":
                this.precedence = 3;
                break;
            case "/":
                this.precedence = 3;
                break;
            case "(":
                this.precedence = 0;
                break;
        }
    }
}
