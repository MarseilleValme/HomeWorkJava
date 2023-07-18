import java.util.*;


public class Task13 {
    /*
    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
    Критерии фильтрации можно хранить в Map.
    Например:
    “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
    Работу сдать как обычно ссылкой на гит репозиторий
    Частые ошибки:
    1. Заставляете пользователя вводить все существующие критерии фильтрации
    2. Невозможно использовать более одного критерия фильтрации одновременно
    3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
    4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук, то программа начинает работать некорректно
     */
    static String[] brands = new String[] {"Apple", "Lenovo", "Asus", "Dell", "HP", "Acer", "MSI", "GigaByte"};
    static String[] cpu = new String[] {"Ryzen 3", "Ryzen 5", "Ryzen 7", "Core i3", "Core i5", "Core i7", "Pentium"};
    static int[] memory = new int[] {8, 16, 32};
    static int[] hdd = new int [] {1, 2};
    static String[] os = new String[] {"Win10 Home", "Win10 Pro", "Win11 Home", "Win11 Pro"};
    static String[] colors = new String[] {"Black", "Silver", "Blue", "Magenta"};

    static Map<Integer, String> criterion = new HashMap<>();

    public static void main(String[] args) {

        Set<Notebook> notebook = new HashSet<>();

        for (int i = 0; i < 100; i++)
            notebook.add(nout());
        output(notebook);

        criterion ();

        Set<Notebook> result = new HashSet<>();
        int count = criterion.size();

        for (Notebook nout: notebook){
            for (var item : criterion.entrySet()) {
                switch (item.getKey()) {
                    case 1:
                        if (nout.brand.equalsIgnoreCase(item.getValue()))
                            count--;
                        break;
                    case 2:
                        if (nout.cpu.equalsIgnoreCase(item.getValue()))
                        count--;
                        break;
                    case 3:
                        if (nout.memory >= Integer.parseInt(item.getValue())) 
                        count--;
                        break;
                    case 4:
                        if (nout.hdd >= Integer.parseInt(item.getValue())) 
                        count--;
                        break;
                    case 5:
                        if (nout.os.equalsIgnoreCase(item.getValue()))
                        count--;
                        break;
                    case 6:
                        if (nout.color.equalsIgnoreCase(item.getValue()))
                        count--;
                        break;
                    case 7:
                        if (nout.price >= Integer.parseInt(item.getValue()))
                        count--;
                        break;
                }
                
            }
            if (count==0)
                    result.add(nout);

            count = criterion.size();
        }
        System.out.println("===========================================================================");
        System.out.println("                        ОТФИЛЬТРОВАННЫЕ НОУТБУКИ");
        System.out.println("===========================================================================");
        output(result);
    }

    public static Notebook nout(){
        Random rnd = new Random();

        Notebook nout = new Notebook(null, null, 0, 0, null, null, 0);

        nout.brand = brands[rnd.nextInt(brands.length)];
        if (nout.brand.equals("Apple")){
            nout.cpu = "M2";
            nout.os = "MacOs";
        }
        else {
            nout.cpu = cpu[rnd.nextInt(cpu.length)];
            nout.os = os[rnd.nextInt(os.length)];
        } 
        nout.memory = memory[rnd.nextInt(memory.length)];
        nout.hdd = hdd[rnd.nextInt(hdd.length)];
        nout.color = colors[rnd.nextInt(colors.length)];
        nout.price = 500 + rnd.nextInt(600) * 10;

        return nout;
    }

    static void output (Set<Notebook> result){
            for (Notebook nout : result)
            System.out.println(nout);
    }
        

    static void criterion () {
        Scanner scanner = new Scanner(System.in);
        
        String menu = "__________________________________________________________________________________\n"+
        "Введите цифру, соответствующую необходимому критерию:\n"+
        "1 - Производитель\n"+
        String.join(", ", brands)+
        "\n2 - Процессор\n"+
        String.join(", ", cpu)+
        "\n3 - Объём ОЗУ\n"+
        String.join(" ", Arrays.toString(memory))+
        "\n4 - Ёмкость винчестера\n"+
        String.join(" ", Arrays.toString(hdd))+
        "\n5 - Операционная система\n"+
        String.join(", ", os)+
        "\n6 - Цвет\n"+
        String.join(", ", colors)+
        "\n7 - Цена\n"+
        "8 - Показать ноутбуки";

        int choice;
        String values;
                
        while (true) {
            System.out.println(menu);
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice==8) {
                scanner.close();
                break;
            }
            System.out.println("Укажите значение");
            values = scanner.nextLine();

            criterion.put(choice, values);
        }
    }
}