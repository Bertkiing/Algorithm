package test;

/**
 * @author bertking
 * @date 2020/1/6
 */
public class DoubleLinkedList {

    static class Element {
        public Element prior = null;
        public Object value = null;
        public Element next = null;
        public Byte[] values = new Byte[SIZE];
        public static int SIZE = 8194;
    }

    private Element header = null;//头结点

    /**
     * 初始化链表
     */
    void initList() {
        header = new Element();
        header.prior = header;
        header.value = null;
        header.next = header;
    }

    /**
     * 向链表中第i个位置插入元素o
     */
    Object insertList(Object o, int i) {
        if (i <= 0 || i > size()) {
            System.out.println("插入位置不合法！链表长度为：" + size());
        } else {
            Element e = new Element();
            e.value = o;
            if (header.prior == header)//第一次插入元素
            {
                e.prior = header;
                e.next = header;
                header.next = e;
                header.prior = e;
            } else if (i == size())//在最后插入
            {
//                System.out.println("在链表尾部插入");
                e.next = header;
                e.prior = header.prior;
                header.prior.next = e;
                header.prior = e;

            } else {
                Element temp = header;
                int count = 0;
                while (temp.next != header) {
                    count++;
                    if (count == i) {
                        e.prior = temp;
                        e.next = temp.next;
                        temp.next.prior = e;
                        temp.next = e;
                    }
                    temp = temp.next;
                }
            }
        }
        return o;
    }

    /**
     * 删除链表中的某个元素
     */
    Element deleteList(int i) {
        if (i <= 0 || i > size()) {
            System.out.println("插入位置不合法！链表长度为：" + size());
            return null;
        } else {
            int count = 0;
            Element temp = header;
            while (temp.next != header) {
                temp = temp.next;
                count++;
                if (i == count) {
                    //删除第i个元素
                    temp.next.prior = temp.prior;
                    temp.prior.next = temp.next;
                }
            }
            return temp;
        }
    }

    /**
     * 打印链表
     */
    void print() {
        System.out.print("打印双向循环链表：");
        Element temp = header;
        while (temp.next != header) {
            System.out.print(temp.next.value + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 获取链表的大小
     */
    int size() {
        int count = 1;
        Element temp = header;
        while (temp.next != header) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}


