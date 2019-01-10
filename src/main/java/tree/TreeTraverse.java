package tree;

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

    // ...


    public static void main(String[] args) {
        TreeNode node = TreeNode.generateTree();
        System.out.println("====== 递归先序遍历 =======");
        preTraverse(node);
        System.out.println("\n====== 递归中序遍历 =======");
        inTraverse(node);
        System.out.println("\n====== 递归后序遍历 =======");
        postTraverse(node);
    }


}
