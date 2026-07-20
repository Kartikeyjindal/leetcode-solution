class Solution 
{
    public int bagOfTokensScore(int[] tokens, int power) 
    {
        Arrays.sort(tokens);
        int score=0;
        int maxscore=0;
        int i=0,j=tokens.length-1;

        while(i<=j)
        {
            if(power>=tokens[i])
            {
                power=power-tokens[i];
                score++;
                i++;
                maxscore=Math.max(maxscore,score);
            }
            else if(score>0)
            {
                power=power+tokens[j];
                j--;
                score--;
            }
            else
            {
                break;
            }
        }
        return maxscore;
    }
}