//     Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//     Создать множество ноутбуков.
//     Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
//     Критерии фильтрации можно хранить в Map.
//     Например:
//     “Введите цифру, соответствующую необходимому критерию:
//     1 - ОЗУ
//     2 - Объем ЖД
//     3 - Операционная система
//     4 - Цвет …
//     Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//     Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
public class Notebook {
    String brand;
    String cpu;
    int memory;
    int hdd;
    String os;
    String color;
    int price;

    public Notebook(String brand, String cpu, int memory, int hdd, String os, String color, int price) {
        this.brand = brand;
        this.cpu = cpu;
        this.memory = memory;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Брэнд: " + brand +
                ", CPU: " + cpu +
                ", ОЗУ: " + memory +
                "Гб, Винт: " + hdd +
                "Тб, ОС: " + os +
                ", Цвет: " + color + 
                ", Цена: " + price + "$";
    }
}