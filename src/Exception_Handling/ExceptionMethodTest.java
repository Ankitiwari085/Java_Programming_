package Exception_Handling;

public class ExceptionMethodTest {
    public static void main(String[] args) {
        try{
            System.out.println(sum(new int[]{1,2,3,4,5}));
        }
        catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
            StackTraceElement [] traceElements =ex.getStackTrace();
            for (int i = 0; i < traceElements.length; i++) {
                System.out.println(traceElements[i].getMethodName()+ traceElements[i].getClassName()+traceElements[i].getLineNumber()
                );

            }
        }
    }
    public static int sum(int[] num){
        int result =0;
        for (int i = 0; i <= num.length ; i++) {
            result+=num[i];
        }
        return result;
    }
}
