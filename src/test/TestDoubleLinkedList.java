package test;

/**
 * @author bertking
 * @date 2020/1/6
 */
public class TestDoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinkedList dlList = new DoubleLinkedList();//有头结点
        dlList.initList();
        dlList.insertList(1, 1);
        dlList.insertList(2, 2);
        dlList.insertList(3, 1);
        dlList.insertList(4, 1);
        dlList.insertList(5, 1);
        dlList.insertList(6, 6);
        dlList.insertList(7, 7);
        dlList.insertList(8, 8);
        dlList.insertList(9, 9);
        dlList.insertList(10, 10);
        dlList.insertList(11, 11);
        dlList.print();
        ElementPool pool = new ElementPool();
        pool.recycle(dlList.deleteList(1));
    }

}
