class Solution {
    public int findPeakElement(int[] arr) {
      int start=0;
      int end=arr.length-1;
      int ans=-1;

 
      while(start<=end)
      {
        int mid=start+((end-start)/2);
        if(mid==arr.length-1)
        {
            return mid;
        }
       else if(arr[mid]>arr[mid+1])
       {
            ans=mid;
            end=mid-1;

        }
        else if(arr[mid]<arr[mid+1]){
            start=mid+1;
        }
      }
      return ans; 
    }
}