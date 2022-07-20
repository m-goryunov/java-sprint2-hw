import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Автоматизатор бухгалтерии. Что вы хотите сделать?");
        printMenu();
        int command = scanner.nextInt();
        while (true){
            if(command == 1){

            }else if(command == 2){

            }else if(command == 3){

            }else if(command == 4){

            }else if(command == 5){

            }else if(command == 0){
                System.out.println("Выход");
                break;
            }else{
                System.out.println("Такая команда не поддерживается");
            }
        }
        printMenu();
        command = scanner.nextInt();
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