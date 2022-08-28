import java.util.ArrayList;
import java.util.HashMap;

public class CalcMonthReport {
    ArrayList<MonthConstructor> recordList;

    public CalcMonthReport(ArrayList<MonthConstructor> recordList){

        this.recordList = recordList;
    }

    public static void calcMonthReport(){
        HashMap<Integer, ArrayList<MonthConstructor>> monthReport;
        monthReport = CreateMonthReport.getReport();
        for (Integer month: monthReport.keySet()) {
            if(month == 1){
                System.out.println("Январь");
            } else if (month == 2) {
                System.out.println("Февраль");
            } else if (month == 3) {
                System.out.println("Март");
            }

            ArrayList<MonthConstructor>mostProfitableWare = monthReport.get(month);

            System.out.println(mostProfitableWare);
        }
        
    }



}
