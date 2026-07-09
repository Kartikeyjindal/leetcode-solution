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
class FindElements {
    HashSet<Integer> set;
    public FindElements(TreeNode root) {
        set= new HashSet<>();
        if(root!=null)
            set.add(0);
        elements(root,0);
       // System.out.println(set);
    }
    private void elements(TreeNode root,int val){
        if(root==null) return;
        root.val=val;
        set.add(val);
        elements(root.left,root.val*2+1);
        
        elements(root.right,root.val*2+2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}


/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */