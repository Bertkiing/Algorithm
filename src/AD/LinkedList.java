package AD;

import java.util.Stack;

/**
 * @author bertking
 * @date 2018/11/7
 * <p>
 * https://www.cnblogs.com/whgk/p/6589920.html
 */
public class LinkedList {
    public Node head;

    /**
     * 直接在链表的最后插入新增的结点即可
     * 将 原来 最后一个结点 ---》新结点
     * <p>
     * 尾插法
     *
     * @param node
     */
    public void addNode(Node node) {
        Node temp = null;
        /**
         * 链表中有结点，需要遍历到最后一个结点
         */
        if (head == null) {
            head = node;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            /**
             * 指向新结点
             */
            temp.next = node;
        }
    }

    /**
     * 在链表的指定位置插入结点
     * (插入操作只需要知道，当前位置的前一个结点)
     *
     * @param index 插入结点的位置，从1开始
     * @param node  待插入的结点
     */
    public void insertNodeByIndex(int index, Node node) {
        /**
         * 判断插入位置是否合法
         */
        if (index < 1 || index > length() + 1) {
            System.out.println("插入位置不合法");
            return;
        }

        int length = 1; // 记录遍历到了第几个位置

        Node temp = head;
        while (head.next != null) { // 遍历单链表
            if (index == length++) {
                node.next = temp.next;
                temp.next = node;
                return;
            }

            temp = temp.next;
        }


    }


    /**
     * 删除指定位置的链表
     *
     * @param index
     */
    public void deleteNodeByIndex(int index) {
        if (index < 1 || index > length()) {
            System.out.println("待删除的位置不合法");
            return;
        }

        int length = 1;


        Node temp = head; // 可移动的指针
        while (temp.next != null) { // 遍历单链表
            if (index == length++) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }

    }


    /**
     * 计算单链表的长度
     *
     * @return 结点个数
     */
    public int length() {
        int length = 0;
        Node temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 打印链表
     */
    public void travese() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println();
    }


    /*************延伸LinkedList*****************/

    /**
     * 从尾到头打印链表
     * <p>
     * 解法：先遍历链表,每遍历到的元素都存在栈中
     */
    public void reverseTraverse(Node node) {
        Stack stack = new Stack();
        Node p = head;

        if (p == null) {
            System.out.println("empty list....");
        }

        while (p != null) {
            stack.push(node.data);
            p = p.next;
        }

        while (stack.isEmpty() != true) {
            Integer pop = (Integer) stack.pop();
            System.out.println(pop);
        }

    }


    /**
     * 输入链表头节点，反转链表并输出反转后链表的头节点
     * <p>
     * 解法:借助于三个指针：p, q , r(避免指针断裂)
     *
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        Node p = head;
        try {
            if (p != null) {
                Node pnext = p.next;
                p.next = null;

                while (pnext != null) {
                    Node r = pnext.next;
                    pnext.next = p;
                    p = pnext;
                    pnext = r;
                }
            } else {
                throw new Exception("empty list");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return p;
        }
    }

    static class Node {
        public int data;

        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node = new Node(1);
        linkedList.addNode(node);
        linkedList.addNode(new Node(2));
        linkedList.addNode(new Node(3));
        linkedList.insertNodeByIndex(2, new Node(10));
        linkedList.deleteNodeByIndex(2);
        int length = linkedList.length();
        System.out.println(length);
        linkedList.travese();

        Node reverse = linkedList.reverse(node);
        System.out.println(reverse.data);

    }


}
