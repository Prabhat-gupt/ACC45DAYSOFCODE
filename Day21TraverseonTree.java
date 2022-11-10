public class Day21TraverseonTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BuildTree{
        static int idx = -1;
        public static Node buildNodeTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node root = new Node(nodes[idx]);
            root.left = buildNodeTree(nodes);
            root.right = buildNodeTree(nodes);
            return root; 
        }
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BuildTree tree = new BuildTree();
        Node root = tree.buildNodeTree(nodes);
        // System.out.println(root.data);
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
    }
}
