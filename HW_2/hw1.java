import java.util.Scanner;

/* Напишите программу, которая запрашивает у пользователя число и проверяет, является ли оно положительным. 
Если число отрицательное или равно нулю, программа должна выбрасывать исключение InvalidNumberException 
с сообщением "Некорректное число". В противном случае, программа должна выводить сообщение "Число корректно". */

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

public class hw1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите число: ");
            int number = sc.nextInt();
            checkPositiveNumber(number);
            System.out.println("Число корректно");
        } catch (InvalidNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkPositiveNumber(int number) throws InvalidNumberException {
        if (number <= 0) {
            throw new InvalidNumberException("Некорректное число");
        }
    }
}
