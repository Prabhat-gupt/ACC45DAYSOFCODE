public class Day28KthLevelTree {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void kLevel(Node newNode,int level,int k){
        if(newNode==null){
            return;
        }

        if(level == k){
            System.out.println(newNode.data+" ");
        }

        kLevel(newNode.left, level+1, k);
        kLevel(newNode.right, level+1, k);
    }

    public static void main(String[] args) {
        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.left = new Node(6);
        newNode.right.right = new Node(7);

        int k = 3;
        kLevel(newNode, 1, k);
    }
}
