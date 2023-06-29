import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task4 {
//     Получить исходную json строку из файла, используя FileReader или Scanner
// Дана json строка вида:
// String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
// "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
// "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

// Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
// результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.
    
        static Logger logger;

    public static void main(String[] args) {

        String filePath = "json.txt";
        String gradebook = readInFile(filePath);

        gradebook = replace(gradebook, "[", "");
        gradebook = replace(gradebook, "]", "");
        gradebook = replace(gradebook, "\"", "");
        gradebook = replace(gradebook, "\\", "");
        gradebook = replace(gradebook, "}", ".");
        gradebook = replace(gradebook, "{фамилия:", "Студент ");
        gradebook = replace(gradebook, ",оценка:", " получил ");
        gradebook = replace(gradebook, ",предмет:", " по предмету ");
        gradebook = replace(gradebook, ", +", "@");

        String[] students = separation(gradebook, "@");

        StringBuilder stringBuilder = new StringBuilder();
        for (String student : students){
            System.out.println(student);
            stringBuilder.append(student);
            }
        String toFile = stringBuilder.toString();
        createLogger();
        writeToFile(toFile, filePath);
        closeLogger();
    }

    static String replace(String str, String oldstring, String newstring) {
        return str.replace(oldstring, newstring);
    }

    static String[] separation(String s, String delimiter) {
        String[] str = s.split(delimiter);
        return str;
    }

    private static void closeLogger() {
        for (Handler handler: logger.getHandlers()){
            handler.close();
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

    static String readInFile(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    static void writeToFile(String toFile, String filePath) {

        try (FileWriter writer = new FileWriter("test.txt")){
            writer.write(toFile);
            writer.write("\n");
            writer.flush();
            logger.info("Запись успешно выполнена");
        } catch (Exception e){
            e.printStackTrace();
            logger.warning("Не удалось записать в файл");
        }
    }
}