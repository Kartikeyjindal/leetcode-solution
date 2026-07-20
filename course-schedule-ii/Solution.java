class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int neighbor : graph.get(current)) 
            {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) 
                {
                    queue.offer(neighbor);
                }
            }
        }
        if (result.size() == numCourses) 
        {
            return result.stream().mapToInt(i -> i).toArray();
        } 
        else 
        {
            return new int[0];
        }
    }
}