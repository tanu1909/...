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
    public void reorderList(ListNode head) {
        ListNode slow=head, fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //rev second half
        ListNode prev=null;
        ListNode curr=slow.next;
        slow.next=null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

ListNode left=head; //head of first list
curr=prev; //head of second list

while(curr!=null){
    ListNode temp1=left.next;
    ListNode temp2=curr.next;

    left.next=curr;
    curr.next=temp1;

    left=temp1;
    curr=temp2;

}

    }
}