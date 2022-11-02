public class Day13CheckStringPalindrome {
    public static boolean isPalindrome(String str){
        int n = str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i) != str.charAt(n-i-1)){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String str = "abcba";

        System.out.println(isPalindrome(str));
    }
}
