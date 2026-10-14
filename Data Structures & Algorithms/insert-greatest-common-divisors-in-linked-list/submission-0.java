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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current=head;
        while(current!=null && current.next!=null){
            int gcd=findgcd(current.val,current.next.val);
            ListNode newNode=new ListNode(gcd);
            newNode.next=current.next;
            current.next=newNode;
            current=newNode.next;
        }
        return head;
    }
    public int findgcd(int a,int b){
        if(b==0) return a;
        return findgcd(b,a%b);
    }
}