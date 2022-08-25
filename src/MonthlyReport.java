import java.util.ArrayList;

public class MonthlyReport {

    ArrayList<MonthConstructor> recordList;

    public MonthlyReport(ArrayList<MonthConstructor> recordList){

        this.recordList = recordList;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "recordList=" + recordList +
                '}';
    }
}
