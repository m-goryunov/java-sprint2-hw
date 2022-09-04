import java.util.ArrayList;
import java.util.HashMap;

public class ReadMonthlyReport {
    ReadCSVUtil readCSVUtil = new ReadCSVUtil();

    public HashMap<Integer, ArrayList<MonthConstructor>> readMonthlyReports(){
        HashMap<Integer,ArrayList<MonthConstructor>> monthlyReportsMap = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            String createReportRaw = readCSVUtil.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            monthlyReportsMap.put(i,createMonthReport(createReportRaw));
        }
        return monthlyReportsMap;
    }

    public ArrayList<MonthConstructor> createMonthReport(String createReportRaw){
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
