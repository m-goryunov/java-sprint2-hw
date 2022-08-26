import java.util.ArrayList;
import java.util.HashMap;

public class CreateMonthReport {
    static ReadCSVUtil readCSVUtil = new ReadCSVUtil();

     static HashMap<Integer, ArrayList<MonthConstructor>> getReport(){
         HashMap<Integer, ArrayList<MonthConstructor>> monthlyReportByMonth = new HashMap<>();
         for (int i = 1; i <= 3; i++) {
            String createReportRaw = readCSVUtil.readFileContentsOrNull("resources/m.20210" + i + ".csv");
             ArrayList<MonthConstructor> monthlyReport = parseAndSplit(createReportRaw);
            monthlyReportByMonth.put(i, monthlyReport);
        }
         return monthlyReportByMonth;
     }
     static ArrayList<MonthConstructor> parseAndSplit(String createReportRaw){
        String[] lines = createReportRaw.split(System.lineSeparator());
        ArrayList<MonthConstructor> recordList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            MonthConstructor record = new MonthConstructor(
                    lineContents[0],
                    Boolean.parseBoolean(lineContents[1]),
                    Integer.parseInt(lineContents[2]),
                    Integer.parseInt(lineContents[3])
            );
            recordList.add(record);
        }
        return recordList;
    }
}
