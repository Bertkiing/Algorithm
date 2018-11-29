package sort;

/**
 * @author bertking
 * @date 2018/11/28
 *
 * @description https://www.jianshu.com/p/eefd58b16382
 */
public class Tree {
    /**
     * 树的节点
     */
    static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        public Node(int value, Node parent, Node left, Node right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }


    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }

    public void insert(int value) {
        Node pre = null;
        Node current = root;

        /**
         * 从根节点开始
         *
         * 这里的while循环的作用：
         * 1. 找到待插入位置的前驱节点
         */
        while (current != null) {
            pre = current;
            if (current.value > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        /**
         * 生成该节点
         */
        current = new Node(value, pre, null, null);

        /**
         * 插入该节点
         */
        if (pre == null) {
            root = current;
        } else {
            if (current.value > pre.value) {
                pre.right = current;
            } else {
                pre.left = current;
            }
        }


    }


    /**
     * 中序遍历，校验树是否创建成功
     * <p>
     * 理论：由于二叉树的特点，所以中序遍历的结果一定是从小到大排好序的...
     *
     * @param node
     */
    public void inOrderSearch(Node node) {
        if (node == null) return;
        inOrderSearch(node.left);
        System.out.print(node.value + ",");
        inOrderSearch(node.right);
    }

    /**
     * 获取最小值
     * <p>
     * 根据二叉排序树的特点：
     * <p>
     * if 最小值 exists, 则 最小值一定是最左子树
     *
     * @return
     */
    public int getMin() {
        Node current = null;
        current = root;
        if (current == null) {
            return Integer.MIN_VALUE;
        } else {
            while (current.left != null) {
                current = current.left;
            }
            return current.value;
        }
    }


    /**
     * 获取最大值
     * <p>
     * 根据二叉排序树的特点:
     * <p>
     * if 最大值 exists，则 最大值一定是最右子树
     *
     * @return
     */
    public int getMax() {
        Node current = null;
        current = root;
        if (current == null) {
            return Integer.MAX_VALUE;
        } else {
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        }

    }


    /**
     * 查找 值为value的节点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        Node current = root;
        while (current != null) {
            if (current.value == value) {
                return current;
            } else if (current.value > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    /**
     * 获取target目标节点的前驱节点
     * 【借助于图更好理解】
     *
     * @param target
     * @return
     */
    public Node getPre(Node target) {
        if (target == null) {
            return null;
        }
        /**
         * 如果左子树不为空，则前驱必为左子树的最右子树
         */
        if (target.left != null) {
            target = target.left;
            while (target.right != null) {
                target = target.right;
            }
            return target;
        } else {
            /**
             * 左子树为空，则沿着其父节点往上走，遇到的第一个非父节点的左节点的节点
             */
            Node parent = target.parent;
            while (parent != null && parent.left == target) {
                target = parent;
                parent = parent.parent;
            }
            return parent;
        }


    }

    /**
     * 获取target的后继节点
     *
     * @param target
     * @return
     */
    public Node getSucceed(Node target) {
        if (target == null) {
            return null;
        }

        if (target.right != null) {
            target = target.right;
            while (target.left != null) {
                target = target.left;
            }
            return target;
        } else {
            Node parent = target.parent;
            while (parent != null && parent.right == target) {
                target = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }


    public void remove(Node target) {
        if (target == null) {
            return;
        }

        /**
         * 1 . target只有右子树
         */
        if (target.left == null) {
            /**
             * 如果target是其父节点的左子树，则需将target的右子树🔗到父节点的左孩子
             */
            if (target.parent.left == target) {
                target.parent.left = target.right;
            } else {
                /**
                 * 如果target是其父节点的右子树，则需将target的右子树🔗到父节点的右孩子
                 */
                target.parent.right = target.right;
            }

            /**
             * 右孩子非空，则右孩子的parent指向target.parent
             */
            if (target.right != null) {
                target.parent.right = target.right;
            }

        } else if (target.right == null) {
            if (target.parent.left == target) {
                target.parent.left = target.left;
            } else {
                target.parent.right = target.left;
            }

            target.left.parent = target.parent;
        } else {
            /**
             * target的左子树 & 右子树 all exist;
             */


            if (target.right.left == null) {
                if (target.parent.left == target) {
                    target.parent.left = target.right;
                } else {
                    target.parent.right = target.right;
                }

                target.parent.parent = target.parent;
                target.right.left = target.left;
            } else {
                Node current = target;
                target = target.right;
                while (target.left != null) {
                    target = target.left;
                }

                current.value = target.value;
                target.parent.left = target.right;
            }


        }


    }


    public static void main(String[] args) {
        int[] a = {15, 4, 6, 3, 1, 7, 20, 24, 18, 25, 22, 21, 23, 5};
        Tree tree = new Tree();
        tree.buildTree(a);
        System.out.print("中序遍历: ");
        tree.inOrderSearch(tree.getRoot());
        System.out.println();
        System.out.println("最大值: " + tree.getMax());
        System.out.println("最小值: " + tree.getMin());
        System.out.println("查找value = 100的节点：" + tree.search(100));
    }


}
