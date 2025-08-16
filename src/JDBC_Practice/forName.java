package JDBC_Practice;

public class forName {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    //    A a =new A();
        //   Class.forName("JDBC_Practice.Anit");

        //  Class.forName("JDBC_Practice.Anit").newInstance();
    }

}

class Anit{
    static {
        System.out.println("Static Method is Invoked");
    }
    {
        System.out.println("Instance Method is Invoked  ");
    }
}