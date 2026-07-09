class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j] != '.')   
                {
                    if(!check(board, i, j, board[i][j]))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board, int row, int col, char digit)
    {
        for(int i=0;i<9;i++)
        {
            if(board[row][i] == digit && col != i)
            {
                return false;
            }
        }

        // Column check
        for(int i=0;i<9;i++)
        {
            if(board[i][col] == digit && row != i)
            {
                return false;
            }
        }
        int subgridRow = (row/3)*3;
        int subgridCol = (col/3)*3;

        for(int i=subgridRow; i<subgridRow+3; i++)
        {
            for(int j=subgridCol; j<subgridCol+3; j++)
            {
                if((i != row || j != col) && board[i][j] == digit)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
