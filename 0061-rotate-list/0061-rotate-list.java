/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // find the length of linkedlist 
        if(head==null || head.next==null || k==0){
            return head ;
        }
        int cnt=1;
        ListNode tail =head ;
        while(tail.next!=null){
            cnt ++;
            tail=tail.next ;
        }
        k=k%cnt ;
        if(k==0)return head ;
        // circular connect (tail will now point to head )
        tail.next =head ;
        // remaining pointer 
        int rem =cnt-k;
        ListNode newTail =head ;
        for(int c =1;c <rem;c++){
            newTail=newTail.next ;
        }
        ListNode newHead =newTail.next ;
        newTail.next =null;
        return newHead ;


        
    }
}