package Practice_Question;
import java.util.*;


public class CalenderPractice {
    public static void main(String[] args) {
//        Date date = new Date();
//        System.out.println("Current Time :- "+date);

       Calendar calendar = new GregorianCalendar();
        System.out.println("Current Time :- "+ new Date());
        System.out.println("Year "+ calendar.get(Calendar.YEAR));
        System.out.println("Month :-"+ calendar.get(Calendar.MONTH));
        System.out.println("Date :- "+ calendar.get(Calendar.DATE));
        System.out.println("hour :- "+ calendar.get(Calendar.HOUR));
        System.out.println("Hour Of Day :- "+ calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute :- "+ calendar.get(Calendar.MINUTE));
        System.out.println("Second "+ calendar.get(Calendar.SECOND));
        System.out.println("Day of  week :- "+ calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("day of Month" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day Of Year :-  "+ calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Week Of the Month :-"+ calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("week Of the Year :- "+ calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("AM/PM :- "+ calendar.get(Calendar.AM_PM));
        System.out.println(new Date()+ " is a "+getday( calendar.get(Calendar.DAY_OF_WEEK)));


    }
    public static String getday(int dayOfWeek){
        switch (dayOfWeek){
            case 1: return "SUNDAY";
            case 2: return "MONDAY";
            case 3: return "TUESDAY";
            case 4: return "WEDNESDAY";
            case 5: return "THURSDAY";
            case 6: return "FRIDAY";
            case 7: return "SATURDAY";

        }
        return  "NULL";
    }
}
