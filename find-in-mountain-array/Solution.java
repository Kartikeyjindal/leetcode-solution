/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution 
{
        public int findInMountainArray(int target, MountainArray mountainArr) 
        {
            int peak = peakMountain(mountainArr);
            int firstTry = BinarySearchl(target,mountainArr, 0, peak);
            if (firstTry != -1) 
            {
                return firstTry;
            }

            // try to search in second half
            return BinarySearchr(target,mountainArr, peak+1,mountainArr.length()-1);
        }// ends of findInMountainArray

            //FINDING THE PIVOT
            public int peakMountain(MountainArray mountainArr)
            {
                int start=0;
                int end =mountainArr.length()-1;

                while(start<end)
                {
                    int mid=start+(end-start)/2;
                    int midvalue=mountainArr.get(mid);
                    if(midvalue > mountainArr.get(mid+1))
                    {
                        end=mid;
                    }
                    else
                    {
                        start=mid+1;
                    }
                }
                return start;
            }//end of peakMountain

            public int BinarySearchl(int target,MountainArray mountainArr,int si,int ei)
            {
                int index = -1;
                while(si <= ei)
                {
                    int mid = si + (ei-si)/2;
                    if(mountainArr.get(mid) < target)
                    {
                        si =  mid+1;
                    }
                    else if(mountainArr.get(mid) > target)
                    {
                       ei = mid-1;
                    }
                    else
                    {
                        index = mid;
                        break;
                    }
                }
                return index;

            }

            public int BinarySearchr(int target,MountainArray mountainArr,int si,int ei)
            {
                int index = -1;
                while(si <= ei)
                {
                    int mid = si + (ei-si)/2;
                    if(mountainArr.get(mid) < target)
                    {
                        ei =  mid-1;
                    }
                    else if(mountainArr.get(mid) > target)
                    {
                        si = mid+1;
                    }
                    else
                    {
                        index = mid;
                        break;
                    }
                }
                return index;

            }
}
