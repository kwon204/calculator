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

    public static void main(String[] args) {
    }

}