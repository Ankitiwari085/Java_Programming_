package Data_Structure_Practice;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList <String> list = new MyLinkedList<String>();
        list.add("Ankit Tiwari");
        list.add("Amit Tiwari");
        list.add("Niraj Tiwari");
        list.insertAtPosition("Prince Tiwari",2);
        list.display();
        list.deleteAtposition(2);
        list.display();
        System.out.println("The Size of the List : - " + list.getSize());
        System.out.println(list.contain("Niraj Tiwari"));
    }

}
