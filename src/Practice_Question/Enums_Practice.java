package Practice_Question;





public class Enums_Practice {

enum Week {
    Monday, Tuesday , Wednesday , Thursday , Friday , Saturday , Sunday;

      Week (){
        System.out.println("Comnstructor Called For  "+ this);
    }
}


    public static void main(String[] args) {
       Week week = Week.Monday;

        for (Week day : Week.values()){
            System.out.print(day +  "  ");
        }
        System.out.println(week);
    }
}
