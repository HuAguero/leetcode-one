package tree;


import java.util.LinkedList;
import java.util.Queue;

public class TreeDeep {

    //树的最小深度
    public static void main(String[] args) {

        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(minDeep(node1));

        TreeNodeDeep node7_ = new TreeNodeDeep(7, null, null);
        TreeNodeDeep node6_ = new TreeNodeDeep(6, node7_, null);
        TreeNodeDeep node5_ = new TreeNodeDeep(5, null, null);
        TreeNodeDeep node4_ = new TreeNodeDeep(4, null, null);
        TreeNodeDeep node3_ = new TreeNodeDeep(3, node6_, null);
        TreeNodeDeep node2_ = new TreeNodeDeep(2, node4_, node5_);
        TreeNodeDeep node1_ = new TreeNodeDeep(1, node2_, node3_);

        System.out.println(minDeep(node1_));
    }

    //深度优先 T：O（N）S:LogN
    public static int minDeep(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDeep(root.left), min);
        }

        if (root.right != null) {
            min = Math.min(minDeep(root.right), min);
        }

        return min + 1;
    }

    //广度优先 T：O（N）S:O(N)
    public static int minDeep(TreeNodeDeep root) {
        if (root == null)
            return 0;

        root.deep = 1;
        Queue<TreeNodeDeep> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNodeDeep node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.deep;
            }

            if (node.left != null) {
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }

            if (node.right != null) {
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }

        return 0;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static class TreeNodeDeep {
        int val;
        TreeNodeDeep left;
        TreeNodeDeep right;
        int deep;

        TreeNodeDeep(int val, TreeNodeDeep left, TreeNodeDeep right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
