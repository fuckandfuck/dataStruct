package tree;


import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description: 二叉树的遍历
 * 1，使用递归进行前，中，后序遍历
 * 2，不使用递归进行前，中，后序以及层次遍历
 * @Author: zhaoweihua
 * @CreateTime: 2019/1/10
 */
public class TreeTraverse {

    //=====================使用递归遍历的方式=============================

    /**
     * 前序遍历
     * @param node
     */
    public static void preTraverse(TreeNode node){
        if(node == null){
            return ;
        }
        System.out.print(node.value + "  ");
        preTraverse(node.left);
        preTraverse(node.right);


    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inTraverse(TreeNode node){
        if(node == null){
            return ;
        }

        inTraverse(node.left);
        System.out.print(node.value + "  ");
        inTraverse(node.right);

    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postTraverse(TreeNode node){
        if(node == null){
            return ;
        }
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.print(node.value + "  ");

    }



    //=====================使用栈和队列的方式=============================

    /**
     * 使用栈的方式进行前序遍历
     * @param node
     */
    public static void preTraverse2(TreeNode node){
        if(node == null){
            return ;
        }
        Stack<Object> stack = new Stack<Object>();
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode pop = (TreeNode)stack.pop();
            System.out.print(pop.value.toString() + "  ");
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
    }

    /**
     * 使用栈的方式进行中序遍历
     */
    public static void inTraverse2(TreeNode head){
        if(head == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || head != null){
            if(head != null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                System.out.print(head.value+"  ");
                head = head.right;
            }
        }
    }

    /**
     * 使用双栈进行后续遍历
     * @param head
     */
    public static void postTraverse2(TreeNode head){
        if(head == null){
            return ;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(head);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            //非常注意，先左后右。
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value + "  ");
        }
    }


    /**
     * 使用队列实现一个层次遍历
     */
    public static void cengciTraverse(TreeNode head){
        if(head == null){
            return ;
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue();
        queue.offer(head);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.value + "  ");
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.generateTree();
        System.out.println("====== 递归先序遍历 =======");
        preTraverse(node);
        System.out.println("\n====== 递归中序遍历 =======");
        inTraverse(node);
        System.out.println("\n====== 递归后序遍历 =======");
        postTraverse(node);
        System.out.println("\n====== 栈前序序遍历 =======");
        preTraverse2(node);
        System.out.println("\n====== 栈中序遍历 =======");
        inTraverse2(node);
        System.out.println("\n====== 栈后序遍历 =======");
        postTraverse2(node);
        System.out.println("\n====== 队列层次遍历 =======");
        cengciTraverse(node);
    }


}
