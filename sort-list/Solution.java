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

class Solution 
{
    public ListNode sortList(ListNode head) 
    {
        ArrayList<Integer>sorted=new ArrayList<>();
        ListNode current=head;
        while(current!= null)
        {
            sorted.add(current.val);
            current=current.next;
        }
        Collections.sort(sorted);

        current=head;
        for(int i=0;i<sorted.size();i++)
        {
            current.val=sorted.get(i);
            current=current.next;
        }
        return head;
    }
}