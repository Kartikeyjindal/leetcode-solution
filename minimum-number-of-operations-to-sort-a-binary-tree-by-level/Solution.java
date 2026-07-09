import java.util.*;

class Solution 
{
    public int minimumOperations(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            ArrayList<Integer> arr = new ArrayList<>();

            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                arr.add(node.val);

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }

            ans += solve(arr);
        }

        return ans;
    }

    public int solve(ArrayList<Integer> arr)
    {
        int n = arr.size();
        if(n <= 1)
            return 0;

        ArrayList<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            map.put(arr.get(i), i);
        }

        int swap = 0;

        for(int i = 0; i < n; i++)
        {
            if(arr.get(i).equals(sorted.get(i)))
                continue;

            int correctIndex = map.get(sorted.get(i));

            map.put(arr.get(i), correctIndex);
            map.put(sorted.get(i), i);

            Collections.swap(arr, i, correctIndex);
            swap++;
        }

        return swap;
    }
}
