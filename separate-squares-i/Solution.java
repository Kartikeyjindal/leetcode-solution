class Solution 
{
    public double separateSquares(int[][] squares) 
    {
        double low=0;
        double high=0;
        double totalarea=0;
        for(int[]row:squares)
        {
            totalarea+=(double)row[2]*(double)row[2];
            high=(double)Math.max(high,row[1]+row[2]);
        }
        double precision=Math.pow(10,-5);
        while(low<high)
        {
            if(high-low<precision)
            {
                break;
            }
            double mid=low+(high-low)/2.0;
            double toparea=solve(squares,mid);
            double bottomarea=totalarea-toparea;
            if(toparea<=bottomarea)
            {
                high=mid;
            }
            else
            {
                low=mid;
            }
        }
        return low;
    }

    public double solve(int [][]sq,double mid)
    {
        double area=0.0;

        for(int []s:sq)
        {
            double y=s[1];
            double w=s[2];

            if(y>=mid)
            {
                area+=w*w;
            }
            else
            {
                if(y+w>=mid)
                {
                    double heigt=y+w-mid;
                    area+=heigt*w;
                }
            }
        }
        return area;
    }
}