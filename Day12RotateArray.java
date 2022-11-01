public class Day12RotateArray {
    public static void rotateArray(int arr[],int k){
        int newarr[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            newarr[(i+k)%arr.length] = arr[i];
        }

        for(int i=0;i<newarr.length;i++){
            arr[i] = newarr[i];
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k = 2;

        rotateArray(arr, k);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
