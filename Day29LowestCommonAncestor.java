import java.util.ArrayList;

public class Day29LowestCommonAncestor {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }

        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if(foundleft || foundright){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static void main(String[] args) {
        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right = new Node(3);
        newNode.right.left = new Node(6);
        newNode.right.right = new Node(7);
        int n1=4,n2=6;
        System.out.println(lca(newNode, n1, n2).data);
    }
}
