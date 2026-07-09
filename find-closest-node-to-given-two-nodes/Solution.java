class Solution 
{
    public int closestMeetingNode(int[] edges, int node1, int node2) 
    {
        int n = edges.length;
        int[] dist1 = getDistances(node1, edges, n);
        int[] dist2 = getDistances(node2, edges, n);
        int minDist = Integer.MAX_VALUE;
        int minNode = -1;
        
        for (int i = 0; i < n; i++) 
        {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) 
            {
                int currentMax = Math.max(dist1[i], dist2[i]);
                if (currentMax < minDist) 
                {
                    minDist = currentMax;
                    minNode = i;
                }
            }
        }
        return minNode;
    }

    private int[] getDistances(int startNode, int[] edges, int n) 
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int currentDistance = 0;
        int currentNode = startNode;
        
        while (currentNode != -1 && dist[currentNode] == Integer.MAX_VALUE) 
        {
            dist[currentNode] = currentDistance;
            currentDistance++;
            currentNode = edges[currentNode];
        }
        return dist;
    }
}