/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return 0;
        }

        traverseInorder(root, list); // Use inorder traversal (sorted order)
        
        return list.get(k - 1); // Fix index (0-based)
    }

    public void traverseInorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverseInorder(node.left, list); // Left (smallest first)
        list.add(node.val);               // Root
        traverseInorder(node.right, list); // Right
    }
}