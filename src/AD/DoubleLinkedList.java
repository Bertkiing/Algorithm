package AD;

/**
 * @author bertking
 * @date 2018/11/7
 * <p>
 * 双向链表
 */
public class DoubleLinkedList {
    /**
     * 哨兵结点nil(作为表头指针)
     */
    private Node nil;


    /**
     * 链表长度
     */
    private int count;

    public DoubleLinkedList() {
        this.nil = new Node();
        nil.next = nil;
        nil.prev = nil;
        count = 0;
    }


    /**
     * 返回当前链表的长度
     *
     * @return
     */
    public int length() {
        return count;
    }


    /**
     * 获取值为value的节点
     *
     * @param value
     * @return
     */
    public Node findNodebyValue(int value) {
        Node result = null;
        Node head = nil;
        while (head.next != nil) {
            if (head.next.item == value) {
                result = head.next;
                break;
            } else {
                head = head.next;
            }
        }
        return result;
    }

    /**
     * 在队首插入一个节点
     * (头结点之后)
     * @param node
     */
    public void insertHeader(Node node) {
        node.next = nil.next;
        nil.next.prev = node;
        nil.next = node;
        node.prev = nil;
        count++;
    }


    /**
     * 根据value删除节点
     * @param node
     * @return
     */
    public Node deleteNode(Node node){
        Node head= nil;
        Node delNode;
        while (head.next != nil){
            if(head.next.item == node.item){
                delNode = head.next;//将要删除的节点
                head.next = delNode.next;
                delNode.next.prev = head;
                delNode = null;
                count --;
            }else{
                head = head.next;
            }
        }
        return node;
    }

    /**
     * 输出链表
     */
    public void traverse(){
        Node head = nil;
        while (head.next != nil){
            System.out.println(head.next.item);
            head = head.next;
        }
    }




    static class Node {
        int item;
        Node next;
        Node prev;

        public Node() {
            item = 0;
            next = null;
            prev = null;
        }

        public Node(int item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}

