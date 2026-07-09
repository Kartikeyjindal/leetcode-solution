class Solution 
{
    public int maximalRectangle(char[][] matrix) 
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][]height=new int[n][m];

        // made height matrix
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if (matrix[i][j]== '1') 
                {
                    height[i][j] = (i == 0) ? 1 : height[i - 1][j] + 1;
                } 
                else 
                {
                    height[i][j]= 0;
                }
            }
        }
        int [][]nsl=nextsmallestleft(height);
        int [][]nsr=nextsmallestright(height);

        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans=Math.max(ans,(height[i][j]*(nsr[i][j]-nsl[i][j]-1)));
            }
        }

        return ans;
        
    }

    public int [][] nextsmallestleft(int [][]height)
    {
        int n=height.length;
        int m=height[0].length;
        int [][]nsl=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Stack<Integer> stack=new Stack<>();
            for(int j=0;j<m;j++)
            {
                while(!stack.isEmpty() && height[i][stack.peek()]>=height[i][j])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    nsl[i][j]=-1;
                }
                else
                {
                    nsl[i][j]=stack.peek();
                }
                stack.push(j);
            }
        }
        return nsl;
    }

    public int [][] nextsmallestright(int [][]height)
    {
        int n=height.length;
        int m=height[0].length;
        int [][]nsr=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Stack<Integer> stack=new Stack<>();
            for(int j=m-1;j>=0;j--)
            {
                while(!stack.isEmpty() && height[i][stack.peek()]>=height[i][j])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    nsr[i][j]=m;
                }
                else
                {
                    nsr[i][j]=stack.peek();
                }
                stack.push(j);
            }
        }
        return nsr;
    }
}