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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Calculate the size 
        ListNode curr =head ;
        int size =0;
        while(curr!=null){
            size ++;
            curr=curr.next ;
        }
        // base case 
        if(n==size){
            // it means we have to delete the first node 
            head =head.next ;
            return head ;
        }
        // find  nth node 
        int i=1;
        int iToFind=size -n;
        ListNode prev=head ;
        while(i<iToFind){
            prev =prev.next ;
            i++;
        }
        prev.next=prev.next.next ;
        return head ;
    }
}