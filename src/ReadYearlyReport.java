import java.util.ArrayList;
import java.util.HashMap;

public class ReadYearlyReport {
    ReadCSVUtil readCSVUtil = new ReadCSVUtil();

    public HashMap<Integer, ArrayList<YearConstructor>> yearlyReports(){
        HashMap<Integer,ArrayList<YearConstructor>> yearlyReportsMap = new HashMap<>();
            String createReportRaw = readCSVUtil.readFileContentsOrNull("resources/y.2021.csv");
            yearlyReportsMap.put(2021,createYearReport(createReportRaw));

        System.out.println(yearlyReportsMap);
        return yearlyReportsMap;
    }

    public ArrayList<YearConstructor> createYearReport(String createReportRaw){
        String[] lines = createReportRaw.split(System.lineSeparator());
        ArrayList<YearConstructor> recordList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            YearConstructor record = new YearConstructor(
                    Integer.parseInt(lineContents[0]),
                    Integer.parseInt(lineContents[1]),
                    Boolean.parseBoolean(lineContents[2])
            );
            recordList.add(record);
        }
        return recordList;
    }
}
