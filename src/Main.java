import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String mainDir = "C:\\Games";

        String[] directoriesCreate = {
                mainDir + "\\src",
                mainDir + "\\src\\main\\",
                mainDir + "\\src\\main\\test",
                mainDir + "\\res",
                mainDir + "\\res\\drawables",
                mainDir + "\\res\\vectors",
                mainDir + "\\res\\icons",
                mainDir + "\\savegames",
                mainDir + "\\temp"
        };

        String[] filesCreate = {
                mainDir + "\\src\\main\\Main.java",
                mainDir + "\\src\\main\\Utils.java",
                mainDir + "\\temp\\Temp.txt",
        };
        StringBuilder log = new StringBuilder();
        java.time.LocalDateTime now = java.time.LocalDateTime.now();

        for (String dir : directoriesCreate) {
            File directory = new File(dir);
            if (directory.mkdir()) {
                log.append(now).append(" Папка успешно создана ").append(dir).append("\n");
            } else {
                log.append(now).append(" Не удалось создать папку или она уже существует ").append(dir).append("\n");
            }
        }
        for (String filePath : filesCreate) {
            File file = new File(filePath);
            try {
                if (file.createNewFile()) {
                    log.append(now).append(" Файл успешно создан ").append(filePath).append("\n");
                } else {
                    log.append(now).append(" Не удалось создать файл или он уже существует ").append(filePath).append("\n");
                }
            } catch (IOException e) {
                log.append(now).append(" Ошибка при создании файла ").append(e.getMessage()).append("\n");
            }
        }
        try (FileWriter writer = new FileWriter(mainDir + "\\temp\\Temp.txt")) {
            writer.write(log.toString());
            System.out.println("Логи успешно записаны в Temp.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи логов " + e.getMessage());

        }
    }
}