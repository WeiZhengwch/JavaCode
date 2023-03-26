public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int[] treeList) {//[1,2,3,4,null,null,5]

    }

    private int recursion(TreeNode tree) {
        if (tree.left != null && tree.right != null) return Math.max(recursion(tree.left), recursion(tree.right)) + 1;
        if (tree.left != null) return recursion(tree.left) + 1;
        if (tree.right != null) return recursion(tree.right) + 1;
        return 1;
    }

    public int getLength() {
        return recursion(this);
    }
}
