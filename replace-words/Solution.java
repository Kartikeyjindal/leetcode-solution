class Solution 
{
    class Trie
    {
        String endword;
        Trie []child;

        Trie()
        {
            endword=null;
            child=new Trie[26];
        } 
    }
    
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        int n=dictionary.size();
        Trie root=new Trie();
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<n;i++)
        {
            insert(root,dictionary.get(i));
        }

        String []word=sentence.split(" ");
        for(int i=0;i<word.length;i++)
        {
            search(root,word[i],ans);
            if(i<word.length-1)
            {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public void insert(Trie root,String s)
    {
        Trie curr=root;
        for(char c:s.toCharArray())
        {
            if(curr.child[c-'a']==null)
            {
                curr.child[c-'a']=new Trie();
            }
            curr=curr.child[c-'a'];
        }
        curr.endword=s;
    }

    public void search(Trie root,String s,StringBuilder ans)
    {
        Trie curr=root;

        for(char c:s.toCharArray())
        {
            int idx=c-'a';

            if(curr.child[idx]==null||curr.endword!=null)
            {
                break;
            }
            curr=curr.child[idx];
        }
        
        if(curr.endword!=null)
        {
            ans.append(curr.endword);
        }
        else
        {
            ans.append(s);
        }
    }
}