package kz.algorithm.data_structure.tree;

import java.util.*;

public class leetcode {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        else
            return height(root.left) + height(root.right);

    }

    public static int height(TreeNode x) {
        if (x == null) return 0;
        int h = 1 + Math.max(height(x.left), height(x.right));
        return h;

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        Stack<TreeNode> stk = new Stack<>();
        stk.add(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (isSameTree(curr, subRoot)) {
                return true;
            }
            if (curr.left != null) {
                stk.add(curr.left);

            }
            if (curr.right != null) {
                stk.add(curr.right);

            }
        }
        return false;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            boolean check;
            if (p.val == q.val) {
                check = true;
            } else {
                check = false;
            }
            return check && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }


    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return put(nums, 0, nums.length-1);
    }

    static TreeNode put(int[] nums, int l, int r){
        if(l > r)
            return null;

        TreeNode new_node = new TreeNode();

        if(l == r){
            new_node.val = nums[l];
            new_node.left = null;
            new_node.right = null;
        }

        else{
            int mid = l + (r-l)/2;
            new_node.val = nums[mid];
            new_node.left = put(nums, l, mid-1);
            new_node.right = put(nums, mid+1, r);
        }
        return new_node;
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 ==null)return null;
        if(root1 == null || root2 == null) return root1==null?root2:root1;
        TreeNode new_node = new TreeNode();
        new_node.val = root1.val +root2.val;

        new_node.left = mergeTrees(root1.left, root2.left);
        new_node.right = mergeTrees(root1.right, root2.right);

        return new_node;

    }
//
//    public List<String> binaryTreePaths(TreeNode root) {
//        Stack <TreeNode> reserv = new Stack<>();
//        Stack <TreeNode> toLoop = new Stack<>();
//        List<String >
//        toLoop.add(root);
//        while (!toLoop.isEmpty()){
//            if(root.left != null && root.right!=null) {
//                TreeNode
//            }
//        }
//    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        leafNode(root,"", result);
        return result;
    }

    public static void leafNode(TreeNode x,String str, List<String> arr ){
        str+=x.val;
        if(x.left == null && x.right == null){
            arr.add(str);
            return;
        }

        if(x.left !=null)leafNode(x.left, str+"->",arr);
        if(x.right !=null)leafNode(x.right, str+"->", arr);

    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(3);
        a.left.left = new TreeNode(5);
        a.right = new TreeNode(2);


        TreeNode b = new TreeNode(2);
        b.left = new TreeNode(1);
        b.left.right = new TreeNode(4);
        b.right = new TreeNode(3);
        b.right.right = new TreeNode(7);
        System.out.println(isSubtree(a, b));
        TreeNode c = mergeTrees(a,b);

        System.out.println(c);
        List<String> f = binaryTreePaths(b);

        sortedArrayToBST(new int[]{-10, -9, 0, 1, 4,5,7,11,25,28});
    }


}
