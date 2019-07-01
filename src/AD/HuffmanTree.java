package AD;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author bertking
 * @date 2018/11/30
 */
public class HuffmanTree {
    static class Node {
        private String data;
        private int weight;
        private Node left;
        private Node right;

        public Node(String data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }


    private static Node buildHaffmanTree(List<Node> list) {
        while (list.size() > 1) {
            quickSort(list, 0, list.size() - 1);
            Node left = list.get(list.size() - 1);// 最小的
            Node right = list.get(list.size() - 2); //次小的

            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            list.remove(list.size() - 1);//删除最小的两个节点
            list.remove(list.size() - 1);
            list.add(parent);//新生成的父节点添加到集合中

        }
        return list.get(0);//返回集合中的唯一节点。即：根节点
    }


    private static void quickSort(List<Node> list, int start, int end) {
        if (start < end) {
            Node base = list.get(start);
            int i = start;
            int j = end + 1;
            while (true) {
                while (i < end && list.get(++i).weight >= base.weight) {
                }
                while (j > start && list.get(--j).weight <= base.weight) {
                }

                if (i < j) {
                    swap(list, i, j);
                } else {
                    break;
                }
            }

            swap(list,start,j);
            quickSort(list,start,j-1);
            quickSort(list,j+1,end);
        }
    }


    private static void swap(List<Node> list, int i, int j) {
        Node temp;
        temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public static List<Node> breadthFirst(Node root) {
        Queue<Node> queue = new ArrayDeque<>();

        List<Node> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        List<Node> nodesList = new ArrayList<Node>();
        nodesList.add(new Node("A", 2));
        nodesList.add(new Node("B", 4));
        nodesList.add(new Node("C", 5));
        nodesList.add(new Node("D", 8));
        Node root = HuffmanTree.buildHaffmanTree(nodesList);
        System.out.println(breadthFirst(root));
    }

}
