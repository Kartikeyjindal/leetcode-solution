class Solution 
{
    public int ladderLength(String start, String end, List<String> wordList) 
    {
        Set<String> wordset=new HashSet<>(wordList);
        int s=start.length();

        if(!wordset.contains(end))
        {
            return 0;
        }

        Queue<String > queue=new LinkedList<>();
        queue.add(start);

        int ans=1;

        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int a=0;a<size;a++)
            {
                String curr=queue.poll();

                if(curr.equals(end))
                {
                    return ans;
                }

                char []currchar=curr.toCharArray();
                for(int i=0;i<s;i++)
                {
                    char originalchar=currchar[i];
                    for(int j=0;j<26;j++)
                    {
                        char replacement = (char) ('a' + j);
                        if(originalchar==replacement)
                        {
                            continue;
                        }
                        currchar[i]=replacement;
                        String newgenes=new String(currchar);

                        if(wordset.contains(newgenes))
                        {
                            queue.add(newgenes);
                            wordset.remove(newgenes);
                        }
                    }
                    currchar[i]=originalchar;
                }
            }
            ans++;
        }
        return 0;
    }
}