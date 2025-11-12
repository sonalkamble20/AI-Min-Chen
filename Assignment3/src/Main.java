
public class Main {
    public static void main(String[] args) {
    Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.print("Inorder: ");
        Node.inorder(root);

        System.out.println(Node.inorder(root.left) - Node.inorder(root.right));
    }
}

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }

    static int inorder(Node root) {
        if (root != null)
            return 1 + inorder(root.left) + inorder(root.right);
        else
            return 0;
    }
}