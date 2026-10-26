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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> list=new ArrayList<>();
        for(ListNode node:lists){
            while(node!=null){
                list.add(node);
                node=node.next;
            }
        }
        Collections.sort(list,(a,b)->a.val-b.val);
        if(list.isEmpty()) return null;
        for(int i=0;i<list.size()-1;i++){
            list.get(i).next=list.get(i+1);
        }
        list.get(list.size()-1).next=null;
        return list.get(0);

    }
}
