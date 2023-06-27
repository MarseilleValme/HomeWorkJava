// 3) Реализовать простой калькулятор
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1-е число");
        Double fst_number = scanner.nextDouble();
        System.out.println("Введите 2-е число");
        Double scnd_number = scanner.nextDouble();
        System.out.println("Введите знак операции: +, -, *, /");
        String input = scanner.next();
        char sign = input.charAt(0);
        switch (sign) {
            case ('+'):
                System.out.printf("%.0f + %.0f = %.0f", fst_number, scnd_number, fst_number + scnd_number);
                break;
            case ('-'):
                System.out.printf("%.0f - %.0f = %.0f", fst_number, scnd_number, fst_number - scnd_number);
                break;
            case ('*'):
                System.out.printf("%.0f * %.0f = %.0f", fst_number, scnd_number, fst_number * scnd_number);
                break;
            case ('/'):
                System.out.printf("%.0f / %.0f = %.4f", fst_number, scnd_number, fst_number / scnd_number);
                break;
        }
        scanner.close();
    }
        
}
