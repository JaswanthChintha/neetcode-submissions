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
    public ListNode reverseList(ListNode head) {
        ArrayList<ListNode> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp);
            temp=temp.next;
        }
        Collections.reverse(list);
        for(int i=0;i<list.size()-1;i++){
            list.get(i).next=list.get(i+1);
        }
        if(list.size()>0){
            list.get(list.size()-1).next=null;
        }
        if(list.size()>0) return list.get(0);
        return null;
    }
}
