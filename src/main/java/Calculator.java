import java.util.Scanner;

public class Calculator {
    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        String[] tokens = input.trim().split("[,:]");
        int result = 0;
        for(String token : tokens) {
            token = token.trim();
            result += Integer.parseInt(token);
        }

        return result;
    }

    int calculate(String input) throws IllegalArgumentException {
        if (input == null || input.isBlank()) {
            return 0;
        }

        String[] tokens = input.trim().split(" +");

        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException();
        }

        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i+=2) {
            String operator = tokens[i];
            String stringOperand = tokens[i + 1];
            int operand = Integer.parseInt(stringOperand);
            result = switch (operator) {
                case "+" -> {yield add(result, operand);}
                case "-" -> {yield subtract(result, operand);}
                case "*" -> {yield multiply(result, operand);}
                case "/" -> {yield divide(result, operand);}
                default -> {throw new IllegalArgumentException();}
            };
        }

        return result;
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        Integer output = null;
        while(output == null){
            String input = sc.nextLine();
            try {
                output = calculate(input);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("다시 입력.");
            }
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.run();
    }

}