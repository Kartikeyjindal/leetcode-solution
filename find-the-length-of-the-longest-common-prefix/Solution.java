class Solution 
{
    class Trie
    {
        Trie []child=new Trie[10];
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        int n=arr1.length;
        int m=arr2.length;
        Trie root=new Trie();

        for(int i:arr1)
        {
            insert(root,String.valueOf(i));
        }

        int ans=0;

        for(int i:arr2)
        {
            ans=Math.max(ans,search(root,String.valueOf(i)));
        }
        return ans;
        
    }

    public void insert(Trie root,String s)
    {
        Trie curr=root;
        for(char c:s.toCharArray())
        {
            int idx=c-'0';
            if(curr.child[idx]==null)
            {
                curr.child[idx]=new Trie();
            }
            curr=curr.child[idx];
        }
    }

    public int search(Trie root,String s)
    {
        Trie curr=root;
        int len=0;

        for(char c:s.toCharArray())
        {
            int idx=c-'0';
            if(curr.child[idx]==null)
            {
                break;
            }
            curr=curr.child[idx];
            len++;
        }
        return len;
    }
}