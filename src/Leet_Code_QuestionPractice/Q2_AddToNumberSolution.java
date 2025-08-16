package Leet_Code_QuestionPractice;


//  Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

 class Solution {
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head =new ListNode(0);
       ListNode current=head;
       int carry = 0 ;
          while (l1 != null || l2!=null){
              int val1= (l1!=null)?l1.val:0;
              int val2 =(l2!=null)?l2.val:0;
              int sum= val1+val2+carry;
              carry =(sum/10)>0?1:0;

              current.next=new ListNode(sum%10);
              current=current.next;
              if (l1 != null){
                  l1=l1.next;
              }
              if (l2!=null){
                  l2 = l2.next;
              }
              if(carry>0){
                  current.next =new ListNode(carry);
              }

          }

       return head.next;
    }
}
//
//public class Q2_AddToNumberSolution  {
////    public static void main(String[] args) {
////        ListNode l1 =new ListNode(9);
////        ListNode l2 =new ListNode(9);
////       ListNode l3 =addTwoNumbers(l1,l2);
////       while(l3!= null){
////           System.out.print(" " + l3.val);
////           l3=l3.next;
////       }
//
//    }
//}