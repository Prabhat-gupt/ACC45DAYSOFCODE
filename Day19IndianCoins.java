import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Day19IndianCoins {
    public static void main(String[] args) {
        Integer coin[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 590;
        Arrays.sort(coin, Comparator.reverseOrder());
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<coin.length;i++){
            // System.out.println(coin[i]);
            if(coin[i] <= amount){
                while(coin[i] <= amount){
                    count++;
                    ans.add(coin[i]);
                    amount = amount - coin[i];
                }
            }
        }

        System.out.println(count);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+" ");
        }
    }
}
