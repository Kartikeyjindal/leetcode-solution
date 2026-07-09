class Solution 
{
    public int[][] diagonalSort(int[][] mat) 
    {
        int m=mat.length;
        int n=mat[0].length;
        int r=m;
        while(r>0)
        {
            int i=r-1;
            int j=0;
            ArrayList<Integer> curr=new ArrayList<>();
            while(i<m && j<n)
            {
                curr.add(mat[i][j]);
                i++;
                j++;
            }
            Collections.sort(curr);
            i=r-1;
            j=0;
            int k=0;
            while(i<m && j<n && k<curr.size())
            {
                mat[i][j]=curr.get(k);
                k++;
                i++;
                j++;
            }

            r--;
        }
        int a=1;
        while(a<n)
        {
            int i=0;
            int j=a;
            ArrayList<Integer> curr=new ArrayList<>();
            while(i<m && j<n)
            {
                curr.add(mat[i][j]);
                i++;
                j++;
            }
            Collections.sort(curr);
            i=0;
            j=a;
            int k=0;
            while(i<m && j<n && k<curr.size())
            {
                mat[i][j]=curr.get(k);
                k++;
                i++;
                j++;
            }
            a++;
        }
        return mat;
    }
}