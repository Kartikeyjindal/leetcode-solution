class Solution {
    public String largestOddNumber(String num) 
    {
        char ch=' ';
        for(int i=num.length()-1;i>=0;i--)
        {
            ch=num.charAt(i);
            if(ch%2==0)
            {
                num=num.substring(0,num.length()-1);
            }
            else
            {
                return num;
            }
        }
        return "";
    }
}