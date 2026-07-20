class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        boolean found = false;
        for(int i=1;i<nums.length;i++){
            if(found == true && nums[i]!=nums[i-1]){
                return nums[i-1];
            }else if(nums[i]!=nums[i-1]){
                found= true;
            }else if(nums[i]==nums[i-1]){
                found= false;
            }
        }
        if(nums[1]!=nums[0]){
            return nums[0];
        }
        return nums[nums.length-1];
    }
}