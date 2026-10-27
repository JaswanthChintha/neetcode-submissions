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
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        for(int i=0;i+k<=list.size();i+=k){
            Collections.reverse(list.subList(i,i+k));
        }
        for(int i=0;i<list.size()-1;i++){
            list.get(i).next=list.get(i+1);
        }
        list.get(list.size()-1).next=null;
        return list.get(0);
        
    }
}
