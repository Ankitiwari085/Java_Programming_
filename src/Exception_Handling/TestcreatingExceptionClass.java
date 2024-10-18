package Exception_Handling;

public class TestcreatingExceptionClass {
    public static void main(String[] args) throws creatingExceptionClass {
        try{
            creatingExceptionClass c1 =new creatingExceptionClass(4);
            c1.setRadius(-4);
        }
        catch (creatingExceptionClass ex){
            System.out.println( "The Invalid Radius   :  "+ex.getRadius());

            System.out.println(ex);
        }
    }

}
