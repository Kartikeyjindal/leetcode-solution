class Solution 
{
    List<String> ans=new ArrayList<>();
    int r,c;
    int [][]dir={{1,0},{0,1},{0,-1},{-1,0}};

    class TrieNode
    {
        boolean endword;
        TrieNode[] child;
        String word;

        public TrieNode()
        {
            endword=false;
            child=new TrieNode[26];
            word="";
        }
    }

    public void insert(TrieNode root,String s)
    {
        TrieNode cur=root;

        for(char ch:s.toCharArray())
        {
            if(cur.child[ch-'a']==null)
            {
                cur.child[ch-'a']=new TrieNode();
            }
            cur=cur.child[ch-'a'];
        }
        cur.endword=true;
        cur.word=s;
    }

    public void dfs(char[][] board,int i,int j,TrieNode root)
    {
        if(i<0 || i>=r || j<0 || j>=c || board[i][j]=='$' || root.child[board[i][j]-'a']==null)
        {
            return ;
        }

        root=root.child[board[i][j]-'a'];

        if(root.endword)
        {
            ans.add(root.word);
            root.endword=false;
        }

        char temp=board[i][j];
        board[i][j]='$';

        for(int []p:dir)
        {
            int nr=i+p[0];
            int nc=j+p[1];
            dfs(board,nr,nc,root);
        }
        board[i][j]=temp;
    }


    public List<String> findWords(char[][] board, String[] words) 
    {
        r=board.length;
        c=board[0].length;

        TrieNode root=new TrieNode();

        for(String w:words)
        {
            insert(root,w);
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                char ch=board[i][j];
                if(root.child[ch-'a']!=null)
                {
                    dfs(board,i,j,root);
                }
            }
        }
        return ans;
    }
}