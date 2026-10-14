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
        ArrayList<ListNode> list=new ArrayList<>();
        ListNode current=head;
        while(current!=null){
            list.add(current);
            current=current.next;
        }
        ArrayList<ListNode> list1=new ArrayList<>();
        int left=0;
        int right=list.size()-1;
        while(left<=right){
            list1.add(list.get(left));
            left++;
            if(left<=right){
                list1.add(list.get(right));
                right--;
            }
        }
        for(int i=0;i<list1.size()-1;i++){
            list1.get(i).next=list1.get(i+1);
        }
        list1.get(list1.size()-1).next=null;
    }
}
