public class Day36SubsetOfString {
    public static void printSubset(String str,String newstr,int i){
        if(i==str.length()){
            if(newstr.length()==0){
                System.out.println("Null");
            }else{
                System.out.println(newstr);
            }
            return;
        }

        printSubset(str, newstr+str.charAt(i), i+1);
        printSubset(str, newstr, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        printSubset(str, "", 0);
    }
}
