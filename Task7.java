import java.util.ArrayList;
import java.util.Collections;

public class Task7 {
    public static void main(String[] args) {
        // Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. Вывести название каждой планеты и количество его повторений в списке. Collections.frequency(list, item)
        
        ArrayList<String> listOfPlanet = new ArrayList<String>();
        listOfPlanet.add("Меркурий");
        listOfPlanet.add("Венера");
        listOfPlanet.add("Земля");
        listOfPlanet.add("Марс");
        listOfPlanet.add("Юпитер");
        listOfPlanet.add("Сатурн");
        listOfPlanet.add("Уран");
        listOfPlanet.add("Нептун");
        System.out.println("Исходный список: "+listOfPlanet);

        ArrayList<String> myList = new ArrayList<String>();
        int lengthOfList = 20;
        int diapStart = 0;
        int diapFinish = listOfPlanet.size();
        
        for (int i = 0; i < lengthOfList; i++)
            myList.add(listOfPlanet.get((int) ( diapStart + Math.random() * diapFinish )));
        System.out.println("Список в произвольном порядке с повторениями: "+myList);

        for (String planet : listOfPlanet)
            System.out.println(planet+": "+Collections.frequency(myList, planet));
    }
}
