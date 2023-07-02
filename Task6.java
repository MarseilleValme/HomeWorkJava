import java.util.ArrayList;
import java.util.Collections;

public class Task6 {
    public static void main(String[] args) {
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()
        ArrayList<Integer> myList = new ArrayList<Integer>();
        int lengthOfList = 20;
        int diapStart = 1;
        int diapFinish = 10;
        Double average = 0d;

        for (int i = 0; i < lengthOfList; i++)
            myList.add((int) ( diapStart + Math.random() * diapFinish ));
        System.out.println("Исходный список: "+myList);
        
        System.out.println("Минимальное значение: "+Collections.min(myList));
        System.out.println("Максимальное значение: "+Collections.max(myList));
        
        for (int i : myList)
            average += i;
        System.out.println("Среднее арифметическое: "+average/lengthOfList);
    }
}
