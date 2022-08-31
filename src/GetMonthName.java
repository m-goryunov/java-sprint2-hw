public class GetMonthName {

    private static final String[] months = {"Январь","Февраль","Март"};

    public static String getMonthName(int monthNumber){

            return months[monthNumber - 1];
        }
}
