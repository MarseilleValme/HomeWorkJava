// import javax.swing.text.html.FormView;

// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
public class Task1 {
    public static void main(String[] args) {
        double n = 6;
        double tri_number = 0;
        int fac = 1;
        tri_number = (n/2)*(n+1);
        for (int i = 2; i <= n; i++) fac *=i;
        System.out.println("Треугольное число = "+tri_number);
        System.out.println("Факториал = "+fac);
    }
}