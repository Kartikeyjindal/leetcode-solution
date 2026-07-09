class NumArray 
{
    int[] st;
    int n;
    public NumArray(int[] nums) 
    {
        n=nums.length;
        st=new int[4*n];
        segment(nums,0,n-1,0);
    }
    public void segment(int []nums,int l,int r,int idx)
    {
        if(l==r)
        {
            st[idx]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;
        segment(nums,l,mid,2*idx+1);
        segment(nums,mid+1,r,2*idx+2);
        st[idx]=st[2*idx+1]+st[2*idx+2];
    }
    public void update(int index, int val) 
    {
        upd(index,val,0,n-1,0);
    }

    public void upd(int index,int val,int left,int right,int idx)
    {
        int mid=left+(right-left)/2;
        if(left==right)
        {
            st[idx]=val;
            return;
        }
        else if(index<=mid)
        {
            upd(index,val,left,mid,2*idx+1);
        }
        else if(index>mid)
        {
            upd(index,val,mid+1,right,2*idx+2);
        }
        st[idx]=st[2*idx+1]+st[2*idx+2];
    }
    
    public int sumRange(int left, int right) 
    {
        return range(left,right,0,n-1,0);
    }
    public int range(int left,int right,int start,int end,int idx)
    {
        if(right<start||left>end)
        {
            return 0;
        }
        if(left<=start && end<=right)
        {
            return st[idx];
        }
        int mid=start+(end-start)/2;
        return range(left,right,start,mid,2*idx+1)+range(left,right,mid+1,end,2*idx+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */