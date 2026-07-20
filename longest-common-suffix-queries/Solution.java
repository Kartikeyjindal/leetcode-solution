class Solution 
{
    class Trie
    {
        int idx;
        Trie []child;

        Trie(int i)
        {
            idx=i;
            child=new Trie[26];
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) 
    {
        int m=wordsContainer.length;
        int n=wordsQuery.length;

        int[]result=new int[n];

        Trie root=new Trie(0);

        for(int i=0;i<m;i++)
        {
            if(wordsContainer[root.idx].length()>wordsContainer[i].length())
            {
                root.idx=i;
            }
            insert(root,i,wordsContainer);
        }

        for(int i=0;i<n;i++)
        {
            result[i]=search(root,wordsQuery[i]);
        }
        return result;
    }

    public void insert (Trie curr,int i,String[]wordsContainer)
    {
        String word=wordsContainer[i];
        int n=word.length();

        for(int j=n-1;j>=0;j--)
        {
            int chidx=word.charAt(j)-'a';

            if(curr.child[chidx]==null)
            {
                curr.child[chidx]=new Trie(i);
            }
            curr=curr.child[chidx];

            if(wordsContainer[curr.idx].length()>n)
            {
                curr.idx=i;
            }
        }
    }

    public int search(Trie curr,String word)
    {
        int resultidx=curr.idx;
        int n=word.length();

        for(int i=n-1;i>=0;i--)
        {
            int chidx=word.charAt(i)-'a';
            curr=curr.child[chidx];

            if(curr==null)
            {
                return resultidx;
            }
            resultidx=curr.idx;
        }
        return resultidx;
    }
}