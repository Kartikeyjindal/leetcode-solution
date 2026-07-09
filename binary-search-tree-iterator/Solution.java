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
class BSTIterator
{
    ArrayList<Integer> arr=new ArrayList<>();
    int i=0;
    public BSTIterator(TreeNode root) 
    {
        inorder(root);
    }
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    public int next() 
    {
        return arr.get(i++);
    }
    
    public boolean hasNext() 
    {
        int n=arr.size();
        if(i>n-1)
        {
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */