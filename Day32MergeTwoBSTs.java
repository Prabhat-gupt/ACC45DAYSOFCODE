import java.util.ArrayList;

public class Day32MergeTwoBSTs {
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

    static void getInOder(Node root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }

        getInOder(root.left, arr);
        arr.add(root.data);
        getInOder(root.right, arr);
    }

    static Node buildBST(ArrayList<Integer> arr,int st,int en){
        if(st>en){
            return null;
        }
        int mid = (st+en)/2;
        Node root = new Node(arr.get(mid));
        root.left = buildBST(arr, st, mid-1);
        root.right = buildBST(arr, mid+1, en);
        return root;
    }

    static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static Node mergeBSTs(Node root1,Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOder(root2, arr2);

        ArrayList<Integer> finalArr = new ArrayList<>();
        int  i = 0,j = 0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        return buildBST(finalArr, 0, finalArr.size()-1);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        preOrder(root);
    }
}
