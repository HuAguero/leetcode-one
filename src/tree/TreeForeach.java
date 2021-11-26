package tree;

import sun.reflect.generics.tree.Tree;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

/*
二叉树遍历
前序遍历：根左右
中序遍历：左根右
后序遍历：左右根
层序遍历：从上往下，从左往右

递归遍历：使用递归方法遍历
迭代遍历：使用迭代方法实现递归函数，与递归等价
Morris遍历
 */
public class TreeForeach {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        //preOrderRootLeftRight(node1);
        //midOrderLeftRootRight(node1);
        afterOrderLeftRightRoot(node1);
    }

    //前序遍历
    public static void preOrderRootLeftRight(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);//前序：第一次成为栈顶打印

        preOrderRootLeftRight(root.left);
        preOrderRootLeftRight(root.right);
    }

    //中序遍历
    public static void midOrderLeftRootRight(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrderLeftRootRight(root.left);
        System.out.println(root.val);
        midOrderLeftRootRight(root.right);
    }


    //后序遍历
    public static void afterOrderLeftRightRoot(TreeNode root) {
        if (root == null) {
            return;
        }

        afterOrderLeftRightRoot(root.left);
        afterOrderLeftRightRoot(root.right);
        System.out.println(root.val);
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int deep;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
