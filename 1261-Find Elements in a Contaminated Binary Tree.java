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
    Set<Integer> values;

    public FindElements(TreeNode root) {
        HashSet<Integer> values = new HashSet<>();
        recover(root, 0, values);
        this.values = values;
    }

    private static void recover(TreeNode node, int val, Set<Integer> values) {
        if (null == node) { return; }
        node.val = val;
        values.add(val);
        recover(node.left, val * 2 + 1, values);
        recover(node.right, val * 2 + 2, values);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
