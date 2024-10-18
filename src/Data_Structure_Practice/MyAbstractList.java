package Data_Structure_Practice;

public  abstract class MyAbstractList <E> implements  MyList <E> {

    protected  int size =0;
    public MyAbstractList(){

    }


    public MyAbstractList(E [] objects){
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }
        // for linked list , we are creating node for storing the data with their next neighbour relation....



    public void add(E e ){
        add(size, e);
    }

    public boolean isEmpty(){
        return size ==0 ;
    }
    public int size (){
        return  size;
    }

    @Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }
}
