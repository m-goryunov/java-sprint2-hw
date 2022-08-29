import java.util.ArrayList;
import java.util.HashMap;

public class CreateMonthReport {

    ReadCSVUtil readCSVUtil = new ReadCSVUtil();

    ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
    HashMap<Integer,ArrayList<MonthlyReport>> monthlyReportsMap = new HashMap<>();

    public void monthlyReports(){
        for (int i = 1; i <= 3; i++) {
            String createReportRaw = readCSVUtil.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            MonthlyReport monthlyReport = createMonthReport(createReportRaw);
            monthlyReports.add(monthlyReport);
            monthlyReportsMap.put(i, monthlyReports);
        }
        //return monthlyReportsMap;
    }
     public MonthlyReport createMonthReport(String createReportRaw){
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
