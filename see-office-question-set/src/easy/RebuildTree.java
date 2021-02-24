package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * eg，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * limit:
 * 0 <= 节点个数 <= 5000
 *
 * @author chenjianglin
 * @date 2021/2/24
 * @since 1.0.0
 **/
public class RebuildTree {
    //什么是前序遍历 、中须遍历 后序遍历
    //二叉树的前序遍历的顺序为
    /*  [3,9,20,15,7]  3根节点
        先遍历根节点；
        随后递归地遍历左子树；
        最后递归地遍历右子树。
    */
    //二叉树的中序遍历的顺序为：
    /*
        先递归地遍历左子树；
        随后遍历根节点；
        最后递归地遍历右子树
    */

    private Map<Integer, Integer> indexMap;

    //递归法
    private Tree rebuild(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        int inorder_root = indexMap.get(preorder[preorder_left]);

        Tree root = new Tree(preorder[preorder_left]);
        int size_left_subTree = inorder_root - inorder_left;
        root.left = rebuild(preorder, inorder, preorder_left + 1, preorder_left + size_left_subTree, inorder_left, inorder_root - 1);
        root.right = rebuild(preorder, inorder, preorder_left + size_left_subTree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public Tree rebuildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return rebuild(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private void print(Tree root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            print(root.left);
        }
        System.out.print(root.value + " ");
        if (root.right != null) {
            print(root.right);
        }
    }

    private static class Tree implements Comparable<Integer> {
        private final int value;
        private Tree left;
        private Tree right;

        public Tree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "value=" + value +
                    '}';
        }


        @Override
        public int compareTo(Integer o) {
            return o.compareTo(value);
        }
    }

    public static void main(String[] args) {
        RebuildTree tree = new RebuildTree();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Tree trees = tree.rebuildTree(preorder, inorder);
        tree.print(trees);
    }
}
