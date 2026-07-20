class Solution 
{
    public List<Integer> sequentialDigits(int low, int high) 
    {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=9;i++)
        {
            queue.add(i);
        }

        List<Integer> ans=new ArrayList<>();

        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            if(curr >high)
            {
                break;
            }
            if(curr>=low && curr<=high)
            {
                ans.add(curr);
            }

            int dig=curr%10;
            if(dig+1<=9)
            {
                queue.add(curr*10+(dig+1));
            }
        }
        return ans;
    }
}