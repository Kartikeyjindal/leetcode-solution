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
    public int pairSum(ListNode head)
    {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        int k=0;

        while(current !=null)
        {
            values.add(current.val);
            current=current.next;
        }

        List<Integer> twinsums = new ArrayList<>();
        int start = 0;
        int end = values.size()-1;
        while (start <= end)
        {
            twinsums.add(values.get(start++) + values.get(end--));
        }

        int max=0;
        for(int sum: twinsums)
        {
            if(sum>max)
            {
                max=sum;
            }
        }
        return max;
    }
}