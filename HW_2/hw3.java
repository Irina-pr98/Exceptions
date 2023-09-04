import java.util.Scanner;

class NumberOutOfRangeException extends Exception {
    public NumberOutOfRangeException(String message) {
        super(message);
    }
}

class NumberSumException extends Exception {
    public NumberSumException(String message) {
        super(message);
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

public class hw3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            int number1 = sc.nextInt();
            System.out.print("Введите второе число: ");
            int number2 = sc.nextInt();
            System.out.print("Введите третье число: ");
            int number3 = sc.nextInt();
            performNumberChecks(number1, number2, number3);
            System.out.println("Проверка пройдена успешно");
        } catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void performNumberChecks(int number1, int number2, int number3)
            throws NumberOutOfRangeException, NumberSumException, DivisionByZeroException {
        if (number1 > 100) {
            throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        }
        if (number2 < 0) {
            throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        }
        if (number1 + number2 < 10) {
            throw new NumberSumException("Сумма первого и второго чисел слишком мала");
        }
        if (number3 == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        }
    }
}
