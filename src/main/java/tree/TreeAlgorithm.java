package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 算法题
 * 1, 查找两个节点的最近公共祖先
 * 2, 先序中序数组结合重构二叉树
 * 3，如何判断一个二叉树是另一个二叉树的子树
 * @Author: zhaoweihua
 * @CreateTime: 2019/1/10
 */
public class TreeAlgorithm {

    /**
     * 1，查找公共祖先
     * @return
     */
    public static TreeNode ancestor(TreeNode node, TreeNode node1, TreeNode node2){
        if(node == null || node1 == node || node2 == node ){
            return node ;
        }
        TreeNode left = ancestor(node.left, node1, node2);
        TreeNode right = ancestor(node.right, node1, node2);

        //左边有一个，右边有一个的情况，祖先只可能是root
        if(left != null && right != null){
            return node;
        }

        //否则，返回一个祖先的子树
        return left != null ? left : right ;
    }

    public static TreeNode generateTree(String[] pre, String[] in){
        Map<String,Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < in.length ; i ++){
            map.put(in[i], i);
        }
        return generateTreeNode(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    /**
     * 根据先序遍历和中序遍历生成一个二叉树
     * 思路： 根据前序遍历能找到 根节点在中序遍历中的位置
     *      根据中序遍历能找到 根节点的左树的所有元素
     * @param pre 前序数组
     * @param pStart 前序数组开始角标
     * @param pEnd 前序数组结束角标
     * @param in 中序数组
     * @param iStart 中叙述组开始角标
     * @param iEnd 中序数组结束角标
     * @param map 存的是中序数组（value : index）
     * @return
     */
    private static TreeNode generateTreeNode(String[] pre, int pStart, int pEnd, String[] in, int iStart, int iEnd, Map<String, Integer> map){
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }

        TreeNode head = new TreeNode(pre[pStart]);
        Integer index = map.get(pre[pStart]); //root节点在中序遍历中的位置

        head.left = generateTreeNode(pre, pStart+1, pStart + index - iStart, in, iStart, index -1, map);
        head.right = generateTreeNode(pre, pStart + index - iStart + 1, pEnd, in, index + 1, iEnd, map);

        return head;
    };


    /**
     * 3，判断node2树是否为node1树的子数
     * @return
     */
    public static boolean isChild(TreeNode node1, TreeNode node2){
        //1,遍历找出node1中与node2节点相同的节点。
        //2,再判断这两个是否为子树
        if(node1 == null){
            return false;
        }
        if(node2 == null){
            return true;
        }
        if(node1.value == node2.value){
            return isSub(node1,node2);
        }
        boolean leftChild = isChild(node1.left, node2);
        boolean rightChild = isChild(node1.right, node2);

        return leftChild || rightChild;
    }

    /**
     * 根节点相同的两个树，node2是否为node1的子树
     */
    private static boolean isSub(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 != null){
            return false;
        }
        if(node2 == null){
            return true;
        }
        return isSub(node1.left, node2.left) && isSub(node1.right, node2.right);
    }

    public static void main(String[] args) {
        //================ 祖先的测试 =======================
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode X = new TreeNode("x");
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;
        System.out.println(ancestor(A,B,X).value);

        //=======================  子树的测试  =============================
        System.out.println(isChild(A, X));

        //=======================  根据先序遍历和中序遍历生成 二叉树  ===========================
        String[] pre = new String[]{"A", "B", "D", "H", "I", "E", "C", "F", "G"};
        String[] in = new String[]{"H", "D", "I", "B", "E", "A", "F", "C", "G"};
        TreeNode treeNode = generateTree(pre, in);
        TreeTraverse.preTraverse(treeNode);
        System.out.println();
        TreeTraverse.cengciTraverse(treeNode);


    }
}
