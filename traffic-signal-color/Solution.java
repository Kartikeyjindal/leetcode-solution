class Solution 
{
    public String trafficSignal(int time) 
    {
        if(time==0)
        {
            return "Green";
        }
        else if(time==30)
        {
            return "Orange";
        }
        else if(time >30 && time<=90)
        {
            return "Red";
        }
        return "Invalid";
    }
}