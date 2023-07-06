import java.util.LinkedList;
import java.util.ListIterator;

public class Task8 {
    // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список. 
    // Постараться не обращаться к листу по индексам.
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println("Исходный список: "+list);

        System.out.println("Перевернутый список: "+reverse(list));
    }
    static LinkedList<String> reverse(LinkedList<String> list) {
        LinkedList<String> reversedList = new LinkedList<>();
        ListIterator<String> listIterator = list.listIterator(list.size());

        while (listIterator.hasPrevious())
            reversedList.add(listIterator.previous());;
        
        return reversedList;
    }
}

