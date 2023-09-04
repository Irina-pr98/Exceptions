import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileManager {
    public String readFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        }
    }

    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public void copyFile(String sourceFilePath, String destinationFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File destinationFile = new File(destinationFilePath);

        if (!sourceFile.exists()) {
            throw new FileNotFoundException("Файл не найден: " + sourceFilePath);
        }

        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        try {
            String content = fileManager.readFile("example.txt");
            System.out.println("Содержимое файла: ");
            System.out.println(content);

            String newText = "Новый текст для записи в файл";
            fileManager.writeFile("newfile.txt", newText);
            System.out.println("Файл успешно записан");

            fileManager.copyFile("source.txt", "destination.txt");
            System.out.println("Файл успешно скопирован");
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
