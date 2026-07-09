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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if (lists==null || lists.length==0) 
        {
            return null;
        }
        ArrayList<Integer> adj=new ArrayList<>();
        int n=lists.length;

        for(ListNode head:lists)
        {
            while(head!=null)
            {
                adj.add(head.val);
                head=head.next;
            }
        }

        Collections.sort(adj);

        ListNode ans=new ListNode(0);
        ListNode tail=ans;

        for(int i=0;i<adj.size();i++)
        {
            tail.next=new ListNode(adj.get(i));
            tail=tail.next;
        } 
        return ans.next;
    }
}