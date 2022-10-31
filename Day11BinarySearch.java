public class Day11BinarySearch {
    public static int binarySearch(int arr[],int target){
        int start = 0, end = arr.length - 1;

        while(start<=end){
            int midval = (start+end)/2;
            if(arr[midval]==target){
                return midval;
            }

            if(arr[midval]>target){
                end = midval - 1;
            }else{
                start = midval + 1;
            }
        }

        return -1;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr, 5));
    }
}
