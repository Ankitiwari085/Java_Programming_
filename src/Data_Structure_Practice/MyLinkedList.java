package Data_Structure_Practice;

public class MyLinkedList<E> {
    public MyLinkedList(){

    }

    private class Node<E> {
        E data ;
        Node <E> nextAddress;

         Node (E data){
            this.data=data;
        }

        public Node (E data ,Node nextAddress){
            this.data =data;
            this.nextAddress =nextAddress;
        }
    }

    private Node <E> head=null, temp=null, prv =null;
    private  int size =0;


        public void add( E data){
            Node <E> node =new Node<E>(data);
            if (head== null){
                head=node;
                head.nextAddress =null;

            }
            else {
                 temp=head;
                while(temp.nextAddress != null){
                   temp= temp.nextAddress;

                }
               temp.nextAddress=node;
            }
            size++;
        }


        public void insertAtPosition (E data ,int  position){
            Node<E> node  =new Node<E>(data);
            if (head == null){
                System.out.println(" List is Not Created .");
            }
            else {
                temp =head;
                for (int i =1 ; i<= position-1;i++){
                    temp= temp.nextAddress;
                }
                node.nextAddress =temp.nextAddress;
                temp.nextAddress=node;

                size++;
            }
        }

        public void deleteAtposition(int position){
            temp =head;
            for (int i =1;i<=position-1;i++){
                temp=temp.nextAddress;
            }
            temp.nextAddress=(temp.nextAddress).nextAddress;
            size--;
        }

        public void display(){
            temp =head;
            while(temp!= null){
                System.out.print(temp.data +" -> ");
                temp =temp.nextAddress;
            }
            System.out.println("null");
        }

        public boolean contain(E data){
            Node <E> node = new Node<>(data);
            temp=head;
            while(temp != null){
                if (temp.data == data)
                    return true;
              temp =temp.nextAddress;
            }
            return false;

        }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public E pull(){
            E e =null;
            if (head == null)
                System.out.println("The List is Not created .");
            else {
                temp =head;
                while(temp.nextAddress!= null){
                    prv =temp;
                    temp =temp.nextAddress;
                }
                 e = prv.data;
                prv= null;
            }
            return  e;
    }
}
