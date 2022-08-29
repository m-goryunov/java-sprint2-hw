import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    ArrayList<MonthConstructor> recordList;
    HashMap<Integer,ArrayList<MonthConstructor>> monthlyReports = new HashMap<>();

    public MonthlyReport(ArrayList<MonthConstructor> recordList) {
        this.recordList = recordList;
    }

}
