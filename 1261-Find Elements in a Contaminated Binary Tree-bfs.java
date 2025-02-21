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
        ArrayDeque<TreeNode> traversal = new ArrayDeque<>();
        root.val = 0;
        traversal.add(root); 
        while (!traversal.isEmpty()) {
            TreeNode next = traversal.removeFirst();
            values.add(next.val);
            if (null != next.left) {
                next.left.val = next.val * 2 + 1;
                traversal.add(next.left);
            }
            if (null != next.right) {
                next.right.val = next.val * 2 + 2;
                traversal.add(next.right);
            }
        }
        this.values = values;
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
