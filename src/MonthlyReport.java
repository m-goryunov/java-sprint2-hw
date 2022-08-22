import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    ArrayList <String> lines;
    private String readFileContentsOrNull(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
            }
    }
    public void FileToArrayList(){
        for (int i = 1; i<=3;i++) {
            String filePath = "resources/m.20210" + i + ".csv";
            readFileContentsOrNull(filePath);
            lines = new ArrayList<>();
        }
        System.out.println(lines);
    }

}
