public class BinaryTree {

    private int counter = 0;
    private boolean foundFlag = false;

    private class Node {

        int data;
        Node left = null;
        Node right = null;

        private Node (int input) {
            this.data = input;
        }
    }

    private Node root = null;

    private void insertIntoNode(Node targetNode, int input) {
        if (targetNode.data > input) {
            if (targetNode.left == null) {
                targetNode.left = new Node (input);
                System.out.println("New node with value: " + input + " inserted as left child of: " + targetNode.data);
            } else {
                insertIntoNode(targetNode.left, input);
            }
        } else if (targetNode.data < input){
            if (targetNode.right == null) {
                targetNode.right = new Node (input);
                System.out.println("New node with value: " + input + " inserted as right child of: " + targetNode.data);
            } else {
                insertIntoNode(targetNode.right, input);
            }
        } else {
            System.out.println("Duplicate Exists, node not inserted");
        }
    }

    public void insertNode(int input) {
        if (root == null) {
            root = new Node (input);
            System.out.println("Node inserted as root with value: " + root.data);
        } else {
            insertIntoNode(root, input);
        }
    }

    public void inOrder() {
        inOrderTrav(this.root);
    }

    private void inOrderTrav(Node targetNode) {
        if (targetNode.left != null) {
            inOrderTrav(targetNode.left);
        }
        System.out.print(targetNode.data + "-");
        if (targetNode.right != null) {
            inOrderTrav(targetNode.right);
        }
    }

    public void preOrder() {
        preOrderTrav(this.root);
    }

    private void preOrderTrav(Node targetNode) {
        System.out.print(targetNode.data + "-");
        if (targetNode.left != null) {
            preOrderTrav(targetNode.left);
        }
        if (targetNode.right != null) {
            preOrderTrav(targetNode.right);
        }
    }

    public void postOrder() {
        postOrderTrav(this.root);
    }

    private void postOrderTrav(Node targetNode) {
        if (targetNode.left != null) {
            postOrderTrav(targetNode.left);
        }
        if (targetNode.right != null) {
            postOrderTrav(targetNode.right);
        }
        System.out.print(targetNode.data + "-");
    }

    public void findKthSmallest(int k) {
        counter = 0;
        foundFlag = false;
        inOrderIncrement(root, k);
    }

    private void inOrderIncrement(Node current, int k) {
        if (current.left != null) {
            inOrderIncrement(current.left, k);
        }
        if (!foundFlag) {
            counter++;
        }
        if (k == counter && !foundFlag) {
            System.out.println(k + "-th smallest number is: " + current.data);
            foundFlag = true;
        }
        if (current.right != null) {
            inOrderIncrement(current.right, k);
        }
    }

    public void findKthLargest(int k) {
        counter = 0;
        foundFlag = false;
        inOrderRevIncrement(root, k);
    }

    private void inOrderRevIncrement(Node current, int k) {
        if (current.right != null) {
            inOrderIncrement(current.right, k);
        }
        if (!foundFlag) {
            counter++;
        }
        if (k == counter && !foundFlag) {
            System.out.println(k + "-th largest number is: " + current.data);
            foundFlag = true;
        }
        if (current.left != null) {
            inOrderIncrement(current.left, k);
        }
    }

    public static void main(String args[]) {
        BinaryTree testBT = new BinaryTree();

        testBT.insertNode(3);
        testBT.insertNode(2);
        testBT.insertNode(6);
        testBT.insertNode(7);
        testBT.insertNode(5);
        testBT.insertNode(1);

        System.out.println("Inorder traversal: ");
        testBT.inOrder();

        System.out.println("\nPreorder traversal: ");
        testBT.preOrder();

        System.out.println("\nPostorder traversal: ");
        testBT.postOrder();

        System.out.println("\n");
        testBT.findKthSmallest(2);
        testBT.findKthSmallest(4);

        System.out.println("\n");
        testBT.findKthLargest(2);
        testBT.findKthLargest(4);
    }
}