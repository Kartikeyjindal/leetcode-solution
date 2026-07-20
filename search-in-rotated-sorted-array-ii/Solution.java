class Solution {
    public boolean search(int[] arr, int target) {
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==target){
                return true;
            }
             if (arr[s] == arr[mid] && arr[mid] == arr[e]) {
                s = s + 1;
                e = e - 1;
                continue;
            }

            else if(arr[s]<=arr[mid]){
                if(arr[s]<=target && arr[mid]>=target){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }

            }
            else{
                if(arr[e]>=target && target>=arr[mid]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return false;
    }
}