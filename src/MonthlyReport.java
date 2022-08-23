import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<String>> monthUnparsedStorage;
    ArrayList<String> fileContent;
    private String readFileContentsOrNull(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
            }
    }
    public HashMap<Integer, ArrayList<String>> fileToHashmap(){
        monthUnparsedStorage = new HashMap<>();
        for (int i = 1; i<=3;i++) {
            String filePath = "resources/m.20210" + i + ".csv";
            fileContent = new ArrayList<>();
            fileContent.add(readFileContentsOrNull(filePath));
            monthUnparsedStorage.put(i,fileContent);
        }
        return monthUnparsedStorage;
    }
    public void fileParseAndSplit(){
        for (Integer file: fileToHashmap().keySet()) {
           for (String content: fileToHashmap().get(file)) {
               if(file == 1){
                   String [] lines1 = content.split(System.lineSeparator());
                   lines1 = content.split(",");
                   for (int i = 0; i< lines1.length;i++){
                       System.out.println(lines1[i]);
                   }
               } else if(file == 2){
                   String [] lines2 = content.split(System.lineSeparator());
                   lines2 = content.split(",");
               } else if (file == 3) {
                   String [] lines3 = content.split(System.lineSeparator());
                   lines3 = content.split(",");
               }
           }
        }
    }
    public void fileParser() {

    }
}

                   //for (int i = 0; i< lines1.length;i++){
        //System.out.println(lines1[i]);
        //}