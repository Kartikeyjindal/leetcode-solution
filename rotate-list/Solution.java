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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null)
        {
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(head!=null)
        {
            list.add(head.val);
            head=head.next;
        }
        int n=list.size();
        int []arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[(i+k)%n]=list.get(i);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}