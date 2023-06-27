// 2) Вывести все простые числа от 1 до 1000
public class Task2 {
    public static void main(String[] args) {
        double n = 1000;
        System.out.print(2+", ");
            for (int i = 3; i <= n; i+=2){
            int j=2;
            while (j <= i/2 && i % j != 0) j++;
            if (j==i/2+1) System.out.print(i+", ");
            }
    }
}