import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WorkWithFile {
    protected void workWithFile(String fileName, String[] data) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("Файл " + fileName + " создан");
                try(FileWriter writer = new FileWriter(fileName)) {
                    for (int i = 0; i < data.length; i++) {
                        writer.write(data[i] + " ");
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при записи в файл");
                }
            } else {
                System.out.println("Файл " + fileName + " уже существует, произвожу добавление новых данных");
                try(FileWriter writer = new FileWriter(fileName, true);) {
                    writer.write('\n');
                    for (int i = 0; i < data.length; i++) {
                        writer.write(data[i] + " ");
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при записи в файл");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
        }
    }
}
