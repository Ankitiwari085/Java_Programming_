package Practice_Question;

import java.util.ArrayList;

public class GenricsStackUsingArrayList {
    public static void main(String[] args) {
      GenricsStack<String> stringList = new GenricsStack<String>();
      stringList.push("Ankit Tiwari");
      stringList.push("Amit Tiwari");
      stringList.push("Prince Tiwari");
        System.out.println(stringList.getSize());
        System.out.println(stringList.display());
        System.out.println(stringList.pop());
        System.out.println(stringList.display());
        System.out.println(stringList.getSize());
        System.out.println(stringList.peek());
    }
}

class GenricsStack <Object>{
    ArrayList<Object> list = new ArrayList<Object>();

    public int getSize(){
        return list.size();
    }

    public void push (Object o){
        list.add(o);
    }

    public Object pop(){
        Object o = list.get(getSize()-1);
        list.remove(list.size()-1);
         return  o;
     }

     public boolean IsEmpty(){
        return  list.isEmpty();
     }

     public ArrayList<Object> display (){
        return list;
     }

     public  Object peek(){
        return list.get(getSize()-1);
     }
}
