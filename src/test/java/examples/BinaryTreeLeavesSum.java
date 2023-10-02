

//### Binary Tree Leaves Sum

//Implement method to calculate sum of numbers in leaves of binary tree.

//           [7]
//           / ＼
//         [5]  [8]
//         /    /＼
//       (6)  (7) [9]
//                /＼
//              (3) (2)
//
//      6 + 7 + 3 + 2 = 18


package examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BinaryTreeLeavesSum {

    private int sumOfLeaves(Node n) {
        if (n == null)
            return 0;

        if (n.getLeft() == null && n.getRight() == null)
            return n.getValue();

        return sumOfLeaves(n.getLeft()) + sumOfLeaves(n.getRight());
    }

    @Test
    public void testSumOfLeaves() {

        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(8);
        Node node4 = new Node(6);
        Node node5 = new Node(7);
        Node node6 = new Node(9);
        Node node7 = new Node(3);
        Node node8 = new Node(2);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);

        node3.setLeft(node5);
        node3.setRight(node6);

        node6.setLeft(node7);
        node6.setRight(node8);

        Assertions.assertEquals(18, sumOfLeaves(node1));
    }



    class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }
}
