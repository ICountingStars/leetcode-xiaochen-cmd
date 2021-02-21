package test;


/**
 * 二叉搜索树 crud
 *
 * @author chenjianglin
 * @date 2021/2/21
 * @since 1.0.0
 **/
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(3);
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);

        tree.delete(3);
        tree.print();
    }

    private static class BinarySearchTree{
        private Node root;


        /** insert
         * 1.若为null则直接插入
         * 2.不为null时,分两种情况，插入到左边或右边
         * 2.1 val <  root.val 插入左边
         * 如果 root.l == null ( root.l==val ) ,否则递归调用insert
         * 2.2 root.r ==null && val >= root.val 插入右边,否则递归调用insert
         * 如果 root.r == null ( root.r==val ) ,否则递归调用insert
         */
        public boolean insert(int val) {
            if (root == null) {
                root = new Node(val);
                return true;
            }
            return insert(root,val);
        }

        private boolean insert(Node root, int val) {
            int compareTo = root.compareTo(val);
            if (compareTo < 0) {
                if (root.l == null) {
                    root.l = new Node(val);
                    return true;
                } else {
                    return insert(root.l, val);
                }
            } else {
                if (root.r == null) {
                    root.r = new Node(val);
                    return true;
                } else {
                    return insert(root.r, val);
                }
            }
        }

        /**
         * print
         * 1.树的左边开始打印
         * 2.打印树
         * 3.打印树的右边
         */

        public void print() {
            print(root);
        }

        private void print(Node root) {
            if (root == null) {
                return;
            }

            if (root.l != null) {
                this.print(root.l);
            }

            System.out.println(root.val);

            if (root.r != null) {
                this.print(root.r);
            }
        }


        /**
         * searchNode
         * 1.树为null直接返回
         * 2.树不为null 分三种情况
         * 2.1 root.val < target
         * 若 target  == root.l.val 返回，反之递归调用searchNode
         * 2.2 root.val > target
         * 若 target  == root.r.val 返回，反之递归调用searchNode
         * 3.3 root.val == target,直接return
         */

        public Node searchNode(int target) {
            if (root==null) {
                return null;
            }
            return searchNode(root,target);
        }

        private Node searchNode(Node node,int target) {
            if (node==null) {
                return null;
            }
            if (target < node.val) {
                return searchNode(node.l, target);
            } else if (target > node.val) {
                return searchNode(node.r, target);
            }else {
                return node;
            }
        }

        /**
         * delete
         * 首先要找到目标树，并找到它的父树。
         * 然后分以下三种情况
         * 1.目标树无子树(目标树为父树的左子树或右子树)
         *     目标树为父树的左子树,父树的左子树==null
         *     目标树为父树的右子树,父树的右子树==null
         * 2.目标树为单子树(目标树为父树的左子叶树或右叶树)
         *     若目标树为父树的左子树,父树的左子树left == 目标树的不为空的子树
         *     否则父树的右子树left == 目标树的不为空的子树
         * 3.目标树为双子树(目标树为父树的左子叶树或右叶树)
         *     若目标树为父树的左子树,
         *     否则
         */

        public boolean delete(int val) {
            if (root == null) {
                return false;
            }
            if (root.compareTo(val) ==0) {//TODO 删除根节点再遍历打印的时候有问题
                if (root.r == null) {
                    root = root.l;
                }else {
                    root.r.l = root.l;
                    root = root.r;
                }
                return true;
            }
            return delete(null,root,val);
        }

        private boolean delete(Node parent, Node target, int val) {
            if (target == null) {
                return false;
            }

            int compareTo = target.compareTo(val);
            if (compareTo < 0) {
                return delete(parent, target.l, val);
            }
            if (compareTo>0) {
                return delete(parent, target.r, val);
            }

            boolean leftOfParent = false;
            if (parent.l !=null && parent.l.compareTo(val)==0) {
                leftOfParent = true;
            }

            if (target.l==null && target.r==null) {
                if (leftOfParent) {
                    parent.l = null;
                } else {
                    parent.r = null;
                }
            } else if (target.l != null && target.r != null) {//目标元素即有左子树，也有右子树
                // 找到右子树最小值（叶子节点），并将其删除
                Node min = findMin(target.r);
                delete(min.val);
                // 将该最小值替换要删除的目标节点
                min.l = target.l;
                min.r = target.r;
                if (leftOfParent) {
                    parent.l = min;
                } else {
                    parent.r = min;
                }
            } else {
                if (leftOfParent) {
                    parent.l = target.l != null ? target.l : target.r;
                } else {
                    parent.r = target.r != null ? target.r : target.l;
                }
            }
            return true;
        }


        /**
         * 查最小值
         */
        public Node findMin() {
            return findMin(root);
        }

        private Node findMin(Node node) {
            if (node.l == null) {
                return node;
            }
            return findMin(node.l);
        }

        public Node findMax() {
            return findMax(root);
        }

        private Node findMax(Node node) {
            if (node.r==null) {
                return node;
            }
            return findMax(node.r);
        }
    }

    private static class Node implements Comparable<Integer>{
        private final int val;
        private Node l;
        private Node r;
        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Integer o) {
            return o.compareTo(val);
        }
    }
}

