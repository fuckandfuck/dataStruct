package tree;

/**
 * @Description: 二叉树结点
 * @Author: zhaoweihua
 * @CreateTime: 2019/1/10
 */
public class TreeNode {
    public Object value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Object value) {
        this.value = value;
    }

    /**
     * 生成一颗二叉树
     *       A
     *     /   \
     *    B     C
     *   / \   / \
     *  D   E F   G
     * / \
     *H   I
     *
     * 先序遍历结果： A B D H I E C F G
     * 中序遍历结果： H D I B E A F C G
     * 后序遍历结果： H I D E B F G C A
     *
     */
    public static TreeNode generateTree() {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;
        return A;
    }
}
