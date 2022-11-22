public class Day33DeleteNodeBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node buildBST(Node root,int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = buildBST(root.left, val);
        }else{
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    static void inOrder(Node root){
        if(root==null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static Node deleteNode(Node root,int val){
        if(root.data < val){
            root.right = deleteNode(root.right, val);
        }else if(root.data > val){
            root.left = deleteNode(root.left, val);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }

            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            Node IS = findInOrderSuccessor(root.right);
            root.data = root.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }
    static Node findInOrderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int arr[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0;i<arr.length;i++){
            root = buildBST(root, arr[i]);
        }

        inOrder(root);

        root = deleteNode(root, 10);
        System.out.println();
        inOrder(root);  
    }
}
