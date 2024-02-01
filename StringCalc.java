import java.util.InputMismatchException;
import java.util.Scanner;

public class StringCalc {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static String result;

    public static void main(String[] args) {
        System.out.println("Input:");

        String userInput = scanner.nextLine();
        char operation = getOperation(userInput);


        String[] blocks = userInput.split("[+-/*\"]");


        if (blocks.length == 5) {
            String st00 = blocks[0];
            String st01 = blocks[1];
            String st02 = blocks[2];
            String st03 = blocks[3];
            String st04 = blocks[4];

            result = calculated(st01, st04, operation);
            System.out.println("Output:\n" + result);

        } else {
            String st01 = blocks[1];
            String st03 = blocks[3];
            number = Integer.parseInt(st03);
            result = calculated(st01, number, operation);
            System.out.println("Output:\n" + result);
        }
    }

    static char getOperation(String userInput) {
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


    public static String calculated(String str1, String str2, char op) {

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

    public static String calculated(String str, int num, char op) {

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
}
