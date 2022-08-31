import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ReadYearlyReport readYearlyReport = new ReadYearlyReport();
    ArrayList<YearConstructor> yearlyReportsList = readYearlyReport.yearlyReports();
    public void GetProfitPerMonth(){
        System.out.println("шла 2021 година");
        for (YearConstructor record: yearlyReportsList){
            while(record.month != 0){

            }
        }
    }
}

  /*  При вызове этой функции программа должна выводить следующие данные:
        Рассматриваемый год;
        Прибыль по каждому месяцу. Прибыль — это разность доходов и расходов;
        Средний расход за все месяцы в году;
        Средний доход за все месяцы в году.

   */