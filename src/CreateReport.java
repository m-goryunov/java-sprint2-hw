import java.util.ArrayList;

public class CreateReport {
    ReadCSVUtil readCSVUtil = new ReadCSVUtil();

    void readMonthReport(){
        for (int i = 1; i <= 3; i++) {
            String createReportRaw = readCSVUtil.readFileContentsOrNull("resources/m.20210" + i + ".csv");
        }
    }
    void createReport(String createReportRaw){
        String[] lines = createReportRaw.split(System.lineSeparator());
        ArrayList<MonthConstructor> record = new ArrayList<>(

        );
        String[] lineContents = createReportRaw.split(",");


    }
}
