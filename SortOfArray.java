import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.Arrays;
import java.util.logging.SimpleFormatter;

public class SortOfArray {
    static Logger logger;
    public static void main(String[] args) {
        // Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        
        int[] numbers = new int[10];
        int diapStart = 1;
        int diapFinish = 10;

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = ((int) ( diapStart + Math.random() * diapFinish ));
        System.out.println("Исходный массив "+Arrays.toString(numbers));

        createLogger();
        System.out.println("Сортировка пузырьком "+Arrays.toString(bubbleSort(numbers)));

        closeLogger();
        }
    static int[] bubbleSort(int[] bubbleSort) {
        int box = 0;
        int count;
        do {
            count=0;
            for (int i = 1; i < bubbleSort.length; i++) {
                if (bubbleSort[i]<bubbleSort[i-1]) {
                    box=bubbleSort[i-1];
                    bubbleSort[i-1]=bubbleSort[i];
                    bubbleSort[i]=box;
                    count++;
                }
            }
        writeToFile(bubbleSort);
        } while (count!=0);
        return bubbleSort;
    }
    static void writeToFile(int[] toFile) {

        try (FileWriter writer = new FileWriter("bubbleSort.txt", true)){
            writer.append(Arrays.toString(toFile));
            writer.append("\n");
            writer.flush();
            logger.info("Запись успешно выполнена");
        } catch (Exception e){
            e.printStackTrace();
            logger.warning("Не удалось записать в файл");
        }
    }
    private static void createLogger() {
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt", true);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        if (fileHandler != null){
            fileHandler.setFormatter(formatter);
        }
    }
    private static void closeLogger() {
        for (Handler handler: logger.getHandlers()){
            handler.close();
        }
    }
}
