import java.util.*;
import java.util.Comparator;

public class Task12 {
    // Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
    public static void main(String[] args) {
        String s = "Иван Иванов, Светлана Петрова, Кристина Белова, Павел Чернов, Анна Мусина, Петр Лыков, Кристина Белова, Анна Крутова,\n" + 
        "Иван Юрин, Петр Лыков, Павел Чернов, Светлана Петрова, Кристина Белова, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова,\n" +
        "Мария Савина, Мария Рыкова, Марина Лугова, Светлана Петрова, Кристина Белова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";

        s = s.replace(".", "");
        s = s.replace("\n", " ");
        s = s.replace("  ", " ");
        String[] names = s.split(", ");
        
        Map<String, Integer> map = new HashMap<>();

        for (String name: names)
            if (map.containsKey(name))
                map.put(name, map.get(name)+1);
            else
                map.put(name, 1);
        
        TreeMap<Integer, List<String>> sort = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<String, Integer> entry: map.entrySet())
            if (entry.getValue()>1)
                if (sort.containsKey(entry.getValue())) {
                    List<String> list = sort.get(entry.getValue());
                    list.add(entry.getKey());
                } else {
                    String name = entry.getKey();
                    Integer count = entry.getValue();
                    List<String> list = new ArrayList<>();
                    list.add(name);
                    sort.put(count, list);
                }
	    System.out.println(sort);
    }
}
