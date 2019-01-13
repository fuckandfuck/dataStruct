package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Description: 二叉树的最大深度和最小深度
 * @Author: zhaoweihua
 * @CreateTime: 2019/1/10
 */
public class TreeDegree {

    /**
     * 递归求解最大深度
     * @param node
     */
    public static int maxDegree(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = maxDegree(node.left);
        int right = maxDegree(node.right);
        return Math.max(left,right) + 1;
    }

    /**
     * 递归求解最小深度
     * @param node
     */
    public static int minDegree(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        if(node.left == null){
            return minDegree(node.right) + 1;
        }
        if(node.right == null){
            return minDegree(node.left) + 1;
        }

        int left = minDegree(node.left);
        int right = minDegree(node.right);
        return Math.min(left,right) + 1;
    }

    /**
     * 使用层次遍历的方法进行求解最大深度
     * @param node
     * @return
     */
    public static int maxDegree2(TreeNode node){
        if(node == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int degree = 0;
        queue.offer(node);
        while(!queue.isEmpty()){
            degree ++ ;
            int size = queue.size();
            for(int i = 0 ; i < size ; i ++){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return degree;
    }

    /**
     * 使用层次遍历的方法进行求解最小深度
     * @param node
     * @return
     */
    public static int minDegree2(TreeNode node){
        if(node == null){
            return 0;
        }
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
        int degree = 0;
        queue.offer(node);
        while(!queue.isEmpty()){
            degree ++ ;
            int size = queue.size();
            for(int i = 0 ; i < size ; i ++){
                TreeNode poll = queue.poll();
                if(poll.right == null && poll.left == null){
                    return degree;
                }
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return degree;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.generateTree();
        System.out.println(maxDegree(node));
        System.out.println(maxDegree2(node));
        System.out.println(minDegree(node));
        System.out.println(minDegree2(node));
    }
}
