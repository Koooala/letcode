package helloword.leetcode;


import java.util.*;

class TreeNode {
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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }
    // 递归算法
    public static void preOrder(TreeNode root, List<Integer> l) {
        if (root == null) return;
        // 前序遍历
        l.add(root.val); // do something
        preOrder(root.left, l);
        preOrder(root.right, l);


/*     preOrder(root.left,l);  中序
     l.add(root.val);
     preOrder(root.right,l);*/


/*     preOrder(root.left,l); 后序
     preOrder(root.right,l);
     l.add(root.val);*/
    }

    // 非递归先序
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return null;
        // 前序借助栈
        // 压根进去 弹出来 右子树进 ，左子树进
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode t1 = stack.pop();
            res.add(t1.val); // do something
            if (t1.right != null) {
                stack.push(t1.right);
            }
            if (t1.left != null) {
                stack.push(t1.left);
            }
        }
        return res;
    }
   // 中序非递归
    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        // 将所有左子树压入栈中，然后谈一个打印一下，压入右子树
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                res.add(root.val); // do something
                stack.push(root.right);

            }
        }
        return res;
    }
    // 后序非递归
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 后序 和 前序相反
        while (!stack.empty() ) {
            TreeNode t1 = stack.pop();
            res.add(t1.val); // do something
            if (t1.left != null) {
                stack.push(t1.left);
            }
            if (t1.right != null) {
                stack.push(t1.right);
            }
        }
        return res;
    }

    // 宽度遍历
    public static List<List<Integer>> BFSearch(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
       while (queue.size()>0){
           int size = queue.size();
           List<Integer> temp =new ArrayList<>();
           // 遍历队列，把当前层的元素从队列取出来，将下一层放入队列
           for (int i = 0; i <size ; i++) {
               TreeNode  cur=queue.poll();
               temp.add(cur.val);  //do something
               if (cur.left!=null){
                   queue.add(cur.left); // 左节点进
               }
               if (cur.right!=null){
                   queue.add(cur.right); // 右节点进
               }
           }
           res.add(temp);
       }
       return res;
    }

    // 最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return  Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
    // t1 是否是 t2 镜像
    public  static  boolean isMirror(TreeNode t1,TreeNode t2){
        if (t1==null && t2==null) return true;
        if (t1!=null && t2==null) return false;
        if (t1 == null) return false;

        return (t1.val==t2.val)&&isMirror(t1.left,t2.left)&&isMirror(t1.right,t2.right);
    }
    // 路径之和
    public  static  boolean hasPathSum(TreeNode root,int target){
        if (root==null) return false;

         if (root.left==null && root.right==null) {
             return  root.val==target;
         }

        return  hasPathSum(root.left,target-root.val )||hasPathSum(root.right,target-root.val);
    }
}