import java.util.LinkedList;
import java.util.ListIterator;

public class Task10 {
    // Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор.
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("Исходный список: "+list);
        System.out.println("Сумма: "+sum(list));
    }
    static int sum(LinkedList<Integer> list) {
        int sum=0;
        ListIterator<Integer> listIterator = list.listIterator();

        while (listIterator.hasNext())
            sum+=listIterator.next();
        
        return sum;
    }
}

