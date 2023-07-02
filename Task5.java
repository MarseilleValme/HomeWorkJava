import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) {
        // Пусть дан произвольный список целых чисел. Удалить из него четные числа.
        ArrayList<Integer> myList = new ArrayList<Integer>();
        int lengthOfList = 10;
        int diapStart = 1;
        int diapFinish = 10;

        for (int i = 0; i < lengthOfList; i++)
            myList.add((int) ( diapStart + Math.random() * diapFinish ));
        System.out.println("Исходный список: "+myList);

        for (int i = 0; i < myList.size(); i++)
            if (myList.get(i) % 2 == 0){
                myList.remove(i);
                i--;
            }
        System.out.println("Полученный список: "+myList);
    }
}
