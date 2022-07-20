import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class scanMonthlyReport {
    private String readFileContentsOrNull(String path) {
        for (int i=0; i <)
        try {
            return Files.readString(Path.of("resources/m.202101.csv"));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }



}
