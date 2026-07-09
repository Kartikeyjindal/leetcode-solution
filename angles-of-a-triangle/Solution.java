class Solution 
{
    public double[] internalAngles(int[] side) 
    {
        Arrays.sort(side);
        double a=side[0];
        double b=side[1];
        double c=side[2];
        if(a+b<=c)
        {
            return new double[0];
        }

        double a1=Math.acos((b*b+c*c-a*a)/(2*b*c));
        double b1=Math.acos((c*c+a*a-b*b)/(2*a*c));
        double c1=Math.acos((b*b+a*a-c*c)/(2*b*a));

        a1=Math.toDegrees(a1);
        b1=Math.toDegrees(b1);
        c1=Math.toDegrees(c1);

            double []ans=new double[]{a1,b1,c1};

        Arrays.sort(ans);
        return ans;
    }
}