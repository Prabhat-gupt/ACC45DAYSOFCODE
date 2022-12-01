import java.util.HashSet;

public class Day42CountDistinctElement {
    public static void main(String args[]){
        int nums[] = {4,3,2,5,6,7,3,4,2,1};

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        System.out.println("Size of set is "+hs.size());
    }
}
