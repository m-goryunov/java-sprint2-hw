import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadYearlyReport readYearlyReport = new ReadYearlyReport();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        System.out.println("Автоматизатор бухгалтерии. Что вы хотите сделать?");

        while (true){
            printMenu();
           int command = scanner.nextInt();
            if(command == 1){
            }else if(command == 2){
            }else if(command == 3){
            }else if(command == 4){
                System.out.println("Самые прибыльные товары:");
                monthlyReport.getMaxProfitItem();
                System.out.println("Самые большие траты:");
                monthlyReport.getMaxExpense();
            }else if(command == 5){
                readYearlyReport.yearlyReports();
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