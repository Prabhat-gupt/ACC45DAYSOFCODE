public class Day31MirrorBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static Node printMirrorBst(Node root){
        if(root==null){
            return null;
        }

        Node leftSubtree = printMirrorBst(root.left);
        Node rightSubtree = printMirrorBst(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
    }

    public static void main(String[] args) {
        Node newNode = new Node(8);
        newNode.left = new Node(5);
        newNode.right = new Node(10);
        newNode.left.left = new Node(3);
        newNode.left.right = new Node(6);
        newNode.right.right = new Node(11);

        preOrder(newNode);

        newNode = printMirrorBst(newNode);
        System.out.println();
        preOrder(newNode);
    }
}
