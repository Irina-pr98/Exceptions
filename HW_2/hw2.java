import java.util.Scanner;

/* Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление. 
Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException с сообщением 
"Деление на ноль недопустимо". В противном случае, программа должна выводить результат деления.
Обратите внимание, что в обоих задачах используются собственные исключения, которые наследуются от класса Exception. 
Это позволяет нам определить специфическую причину ошибки и передать информацию об ошибке для последующей обработки. */

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class hw2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            double dividend = sc.nextDouble();
            System.out.print("Введите второе число: ");
            double divisor = sc.nextDouble();
            double result = divideNumbers(dividend, divisor);
            System.out.println("Результат деления: " + result);
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double divideNumbers(double dividend, double divisor) throws DivisionByZeroException {
        if (divisor == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
        return dividend / divisor;
    }
}
