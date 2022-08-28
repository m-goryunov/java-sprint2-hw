import java.util.ArrayList;
import java.util.HashMap;

public class CreateMonthReport {
    static ReadCSVUtil readCSVUtil = new ReadCSVUtil();

     static HashMap<Integer, ArrayList<MonthConstructor>> getReport(){
         ArrayList<String> monthName = new ArrayList<>();
         for (int i = 1; i <= 3; i++) {
            String createReportRaw = readCSVUtil.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            ArrayList<MonthConstructor> monthlyReport = parseAndSplit(createReportRaw);
            if(i ==1){
                monthName.add(0,"Январь");
            } else if (i == 2){
                monthName.add(1,"Февраль");
            } else if (i == 3) {
                monthName.add(2,"Март");
            }
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
        return new MonthlyReport(recordList);
    }
}
