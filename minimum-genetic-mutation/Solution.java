class Solution 
{
    public int minMutation(String start, String end, String[] bank) 
    {
        Set<String> bankset=new HashSet<>(Arrays.asList(bank));

        if(!bankset.contains(end))
        {
            return -1;
        }

        Queue<String> queue=new LinkedList<>();
        queue.add(start);
        char []choice={'A','C','G','T'};
        int ans=0;

        while(!queue.isEmpty())
        {
            int size=queue.size();

            for(int i=0;i<size;i++)
            {
                String curr=queue.poll();

                if(curr.equals(end))
                {
                    return ans;
                }

                char[] currchar=curr.toCharArray();

                for(int j=0;j<8;j++)
                {
                    char originalchar=currchar[j];

                    for(char c:choice)
                    {
                        if(c==originalchar)
                        {
                            continue;
                        }

                        currchar[j]=c;
                        String newgenes=new String(currchar);

                        if(bankset.contains(newgenes))
                        {
                            queue.add(newgenes);
                            bankset.remove(newgenes);
                        }
                    }
                    currchar[j]=originalchar;
                }
            }
            ans++;
        }
        return -1;
    }
}