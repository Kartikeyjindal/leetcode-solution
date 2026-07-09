class Solution 
{
    public int[] scoreValidator(String[] events) 
    {
        int n=events.length;
        int score=0;
        int counter=0;

        for(String s:events)
            {
                if(counter==10)
                {
                    break;
                }
                if(s.equals("W"))
                {
                    counter++;
                }
                else if(s.equals("WD")|| s.equals("NB"))
                {
                    score++;
                }
                else
                {
                    score+=Integer.parseInt(s);
                }
            }
        return new int[]{score,counter};
    }
}