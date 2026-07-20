class Solution 
{
    public int lenLongestFibSubseq(int[] arr) 
    {
        HashSet<Integer> hashset=new HashSet<>();
        for(int nums:arr)
        {
            hashset.add(nums);
        }
        int answer=0;

        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int first=arr[i];
                int second=arr[j];
                int sum=first+second;
                int count=2;
                while(hashset.contains(sum))
                {
                    count++;
                    first=second;
                    second=sum;
                    sum=first+second;
                }
                answer=Math.max(answer,count);
            }
        }
        return answer==2?0:answer;
    }
}