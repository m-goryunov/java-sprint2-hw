import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadMonthlyReport readMonthlyReport = new ReadMonthlyReport();
        ReadYearlyReport readYearlyReport = new ReadYearlyReport();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        ReportsCheck reportsCheck = new ReportsCheck();
        System.out.println("Автоматизатор бухгалтерии. Что вы хотите сделать?");
        boolean checkReadOrNotMonth = false;
        boolean checkReadOrNotYear = false;
        while (true){
            printMenu();
           int command = scanner.nextInt();
            if(command == 1){
                checkReadOrNotMonth = true;
                readMonthlyReport.readMonthlyReports();
                System.out.println("Месячные отчет успешно загружены!");
            }else if(command == 2){
                checkReadOrNotYear = true;
                readYearlyReport.readYearlyReports();
                System.out.println("Годовой отчет успешно загружен!");
            }else if(command == 3){
                if (checkReadOrNotMonth && checkReadOrNotYear){
                    reportsCheck.checkReports();
                } else {
                    System.out.println("Вы не считали отчеты!");
                }
            }else if(command == 4){
                if(checkReadOrNotMonth){
                System.out.println("Самые прибыльные товары:");
                monthlyReport.getMaxProfitItem();
                System.out.println("Самые большие траты:");
                monthlyReport.getMaxExpense();
                } else {
                    System.out.println("Вы не считали отчеты!");
                }
            }else if(command == 5){
                if(checkReadOrNotYear) {
                yearlyReport.GetProfitPerMonth();
                yearlyReport.GetAvgIncomeAndExpense();
                } else {
                    System.out.println("Вы не считали отчеты!");
                }
            }else if(command == 0){
                System.out.println("Выход");
                break;
            }else{
                System.out.println("Такая команда не поддерживается");
            }
        }
    }


    public static void printMenu(){
    System.out.println("1. Считать все месячные отчеты");
    System.out.println("2. Считать годовой отчет");
    System.out.println("3. Сверить отчеты");
    System.out.println("4. Вывести информацию о всех месячных отчетах");
    System.out.println("5. Вывести информацию о годовом отчете");
    System.out.println("0. Выход из программы");
    }
}