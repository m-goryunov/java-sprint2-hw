import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TesterClass {

   public void readFileContentsOrNull() {
        for (int i = 1; i <= 3; i++){
            try {
                String fileContent = Files.readString(Path.of("resources/m.20210" + i +".csv"));
                System.out.println(fileContent);
                } catch (IOException e) {
                    System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
                }
        }
   }
}
