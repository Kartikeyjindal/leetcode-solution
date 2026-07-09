class Solution 
{
    public boolean canReach(int[] arr, int start) 
    {
        return solve(arr,start,new boolean [arr.length]);
    }

    public boolean solve(int [] arr,int start,boolean []visited)
    {
        if (start < 0 || start >= arr.length|| visited[start])
        {
            return false;
        }
        if(arr[start]==0)
        {
            return true;
        }
        visited[start]=true;
        boolean left=solve(arr,start-arr[start],visited);
        boolean right=solve(arr,start+arr[start],visited);

        return left||right;
    }
}