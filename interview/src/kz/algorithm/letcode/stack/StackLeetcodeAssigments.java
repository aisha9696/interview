package kz.algorithm.letcode.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackLeetcodeAssigments {

     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
             this.right = right;
          }
      }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            for(int i = 0; i < size; i++){
                TreeNode current = stack.pop();
                result.add(current.val);
                if(current.right !=null){
                    stack.push(current.right);
                }
                if(current.left != null){
                    stack.push(current.left);
                }
            }
        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        Stack<TreeNode> res_stack = new Stack<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            for(int i = 0; i < size; i++){
                TreeNode current = stack.pop();
                res_stack.push(current);
                if(current.right !=null){
                    stack.push(current.right);
                }
                if(current.left != null){
                    stack.push(current.left);
                }
            }
        }

        while (!res_stack.isEmpty()){
            result.add(res_stack.pop().val);
        }
        return result;
    }

   /**Depth first search*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tree = root;
        while (!stack.isEmpty() || tree !=null){
            if(tree != null){
                stack.push(tree);
                tree = tree.left;
            }else{
                TreeNode popped = stack.pop();
                result.add(popped.val);
                tree = popped.right;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = null;
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        //node.left.left = null;
       // node.left.right = new TreeNode(4);
        System.out.println(new StackLeetcodeAssigments().preorderTraversal(node));
        System.out.println(new StackLeetcodeAssigments().postorderTraversal(node));
        System.out.println(new StackLeetcodeAssigments().inorderTraversal(node));
    }
}
