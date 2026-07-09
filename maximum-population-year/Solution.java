class Solution 
{
    public int maximumPopulation(int[][] logs) 
    {
        int n=logs.length;
        int []arr=new int[101];
        for(int []a:logs)
        {
            int birth =a[0];
            int death=a[1];

            arr[birth-1950]+=1;
            arr[death-1950]-=1;
        }
        int maxpol=0;
        int year=0;
        int sum=0;
        int al=arr.length;
        for(int i=0;i<al;i++)
        {
            sum+=arr[i];
            if(sum>maxpol)
            {
                maxpol=sum;
                year=i+1950;
            }
        }
        return year;
    }
}