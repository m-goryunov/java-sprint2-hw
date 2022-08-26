import java.util.ArrayList;
import java.util.HashMap;

public class CalcMonthReport {
    public static void calcMonthReport(){
        HashMap<Integer, ArrayList<MonthConstructor>> monthReport;
        monthReport = CreateMonthReport.getReport();
        for (Integer month: monthReport.keySet()) {
            System.out.println(month);
            ArrayList<MonthConstructor>mostProfitableWare = monthReport.get(month);

            System.out.println(mostProfitableWare);
        }
        
    }



}
