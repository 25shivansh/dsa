/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // APPROACH -1 --> INTUTIVE WITH HASHMAP , TIME COMPLEXITY -->O(N) AND SPACE COMPLEXITY= O(N);
        // STEP 1 CONNECT NEXT POINTER 
        if(head ==null)return null ;
        Map<Node,Node>map=new HashMap<>();
        Node curr =head ;
        Node prev =null;
        Node newHead =null ;
        while(curr!=null){
            Node newNode =new Node(curr.val);
            map.put(curr, newNode);
            if(newHead ==null){
                newHead =newNode ;
                prev=newHead ;

            }else{
                prev.next =newNode ;
                prev =newNode ;
            }
            curr=curr.next ;
           
        }
        // STEP 2 - FILL RANDOM POINTERS 

        curr =head ;
        Node newCurr =newHead ;
        while(curr!=null){
            if(curr.random ==null){
                newCurr.random =null;
            }else{
                newCurr.random = map.get(curr.random);
            }
            curr=curr.next ;
            newCurr=newCurr.next;
        }
        return newHead ;

        // if (head == null) return null;

        // // 1st pass: Copy each node and insert right after original
        // Node curr = head;
        // while (curr != null) {
        //     Node next = curr.next;
        //     Node copy = new Node(curr.val);
        //     curr.next = copy;
        //     copy.next = next;
        //     curr = next;
        // }

        // // 2nd pass: Assign random pointers
        // curr = head;
        // while (curr != null) {
        //     if (curr.random != null) {
        //         curr.next.random = curr.random.next;
        //     }
        //     curr = curr.next.next;
        // }

        // // 3rd pass: Separate the original and copied nodes
        // Node dummyHead = new Node(0);
        // Node copyCurr = dummyHead;
        // curr = head;

        // while (curr != null) {
        //     Node next = curr.next.next;

        //     // extract the copied node
        //     Node copy = curr.next;
        //     copyCurr.next = copy;
        //     copyCurr = copy;

        //     // restore the original list
        //     curr.next = next;
        //     curr = next;
        // }

        // return dummyHead.next;
        
    }
}