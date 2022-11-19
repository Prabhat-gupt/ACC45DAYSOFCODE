public class Day30MinimumDistanceNode {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node lca(Node root,int n1,int n2){
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);

        if(leftlca==null){
            return rightlca;
        }
        if(rightlca==null){
            return leftlca;
        }
        return root;
    }

    public static int minDist(Node root,int n1){
        if(root==null){
            return -1;
        }
        if(root.data==n1){
            return 0;
        }
        int minDist1 = minDist(root.left, n1);
        int minDist2 = minDist(root.right, n1);
        if(minDist1==-1 && minDist2==-1){
            return -1;
        }else if(minDist1==-1){
            return minDist2+1;
        }else{
            return minDist1+1;
        }
    }

    public static int minDistance(Node root,int n1,int n2){
        Node lca = lca(root,n1,n2);
        int dist1 = minDist(lca, n1);
        int dist2 = minDist(lca, n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {
        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.left = new Node(6);
        newNode.right.right = new Node(7);

        int n1 = 4,n2 = 6;
        System.out.println(minDistance(newNode, n1, n2));
    }
}
