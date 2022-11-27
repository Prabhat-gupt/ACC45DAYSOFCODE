public class Day38SortedArrayToBalancedBST {
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
        if(root.data>val){
            root.left = buildBST(root.left, val);
        }
        if(root.data<val){
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static Node balancedBST(int arr[],int st,int en){
        if(st>en){
            return null;
        }
        int mid = (st+en)/2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr, st, mid-1);
        root.right = balancedBST(arr, mid+1, en);

        return root;
    }

    public static void main(String args[]){
        int arr[] = {3,5,6,8,10,11,12};
        Node root = balancedBST(arr, 0, arr.length-1);
        preOrder(root);
    }
}
