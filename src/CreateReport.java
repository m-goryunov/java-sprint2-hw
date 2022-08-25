import java.util.ArrayList;
import java.util.List;

public class CreateReport {
    ReadCSVUtil readCSVUtil = new ReadCSVUtil();

    void readMonthReport(){
        for (int i = 1; i <= 3; i++) {
            String createReportRaw = readCSVUtil.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            createReport(createReportRaw);
        }
    }

    void createReport(String createReportRaw){
        String[] lines = createReportRaw.split(System.lineSeparator());

        List<MonthConstructor> recordList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            MonthConstructor record = new MonthConstructor(
                    lineContents[0],
                    Boolean.parseBoolean(lineContents[1]),
                    Integer.parseInt(lineContents[2]),
                    Integer.parseInt(lineContents[3])
            );
            //recordList.add(record);
            System.out.println(record);
        }



    }
}
