class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int fresh=0;
        Queue<int[]> q  = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    vis[i][j]=true;
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int time =0;
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int s =0;s<size;s++){
                int[]cell = q.poll();
                int i = cell[0];
                int j = cell[1];

                if(i+1 < n && grid [i+1][j]==1 && !vis[i+1][j]){
                    vis[i+1][j]=true;
                    grid[i+1][j]=2;
                    fresh--;
                    q.add(new int[]{i+1,j});
                }

                if (i - 1 >= 0 && grid[i-1][j] == 1 && !vis[i-1][j]) {
                    vis[i-1][j] = true;
                    grid[i-1][j] = 2;
                    fresh--;
                    q.add(new int[]{i-1, j});
                }

                if (j + 1 < m && grid[i][j+1] == 1 && !vis[i][j+1]) {
                    vis[i][j+1] = true;
                    grid[i][j+1] = 2;
                    fresh--;
                    q.add(new int[]{i, j+1});
                }

                if (j - 1 >= 0 && grid[i][j-1] == 1 && !vis[i][j-1]) {
                    vis[i][j-1] = true;
                    grid[i][j-1] = 2;
                    fresh--;
                    q.add(new int[]{i, j-1});
                }

            }

        }
        if (fresh > 0) 
        {
            return -1;
        }
        return time-1;
    }
    
}