import java.util.InputMismatchException;
import java.util.Scanner;

public class StringCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input:");
        String userInput = scanner.nextLine();
        char operation = getOperation(userInput);
        String[] blocks = userInput.split("[+-/*\"]");

        if (blocks.length == 5) {
            String str1 = blocks[1];
            String str4 = blocks[4];

            String result = calculated(str1, str4, operation);
            System.out.println("Output:\n" + concat(result));

        } else {
            String str1 = blocks[1];
            String str3 = blocks[3];
            int number = Integer.parseInt(str3);
            String result = calculated(str1, number, operation);
            System.out.println("Output:\n" + concat(result));
        }
    }

    private static char getOperation(String userInput) {
        char operation = '+';

        for (int i = 0; i < userInput.length(); i++) {
            char ch = userInput.charAt(i);
            if (ch == '+') {
                operation = '+';
            }

            if (ch == '-') {
                operation = '-';
            }

            if (ch == '*') {
                operation = '*';
            }

            if (ch == '/') {
                operation = '/';
            }
        }

        return operation;
    }

    private static String calculated(String str1, String str2, char op) {
        String result = "";
        switch (op) {
            case '+':
                result = str1 + str2;
                break;

            case '-':
                result = str1.replaceAll(str2, "");
                break;

            case '*':
                System.out.println("Неверный знак операции * (введите + или -)");
                break;

            case '/':
                System.out.println("Неверный знак операции / (введите + или -)");
                break;

            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }

        return result;
    }

    private static String calculated(String str, int num, char op) {
        String result = "";

        switch (op) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)");
                break;

            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;

            case '*':
                for (int u = 0; u < num; u++) {
                    result = result + str;
                }
                break;

            case '/':
                try {
                    int resultB = str.length() / num;
                    result = str.substring(0, resultB);
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                } finally {
                    if (str.length() < num) {
                        System.out.println("Делимое меньше делителя");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }

        return result;
    }

    private static String concat(String str) {
        int maxLength = 40;
        if (str.length() > maxLength) {
            str = str.substring(0, maxLength);
            str = str + "...";
            return str;
        }

        return str;
    }
}