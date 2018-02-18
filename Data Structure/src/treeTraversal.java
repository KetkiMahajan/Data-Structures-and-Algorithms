class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class treeTraversal {
    Node root;

    treeTraversal() {
        root = null;
    }

    public static void main(String[] args) {
        treeTraversal tree = new treeTraversal();

        tree.root = new Node(2);
        tree.root.left = new Node(1);
        tree.root.right = new Node(3);
        System.out.println("Pre order traversal- N-L-R");
        tree.printPostorder();
    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {

        if (root.data > Math.min(p.data, q.data)) return lowestCommonAncestor(root.left, p, q);
        if (root.data < Math.min(p.data, q.data)) return lowestCommonAncestor(root.right, p, q);
        return root;

    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.data);
    }

    void printPostorder() {
        printPostorder(root);
    }
}
