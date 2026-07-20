class Solution {
    public int numIslands(char[][] grid) 
    {
        if (grid == null || grid.length == 0) 
        {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                if (grid[i][j] == '1') 
                {
                    numIslands++; 
                    bfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void bfs(char[][] grid, int startX, int startY) 
    {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY});
        grid[startX][startY] = '0'; 

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) 
            {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == '1') 
                {
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = '0';
                }
            }
        }
    }
}