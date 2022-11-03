public class Day14ShortestPathString {
    public static float getShortestPath(String path){
        int x = 0,y = 0;
        for(int i=0;i<path.length();i++){
            char c = path.charAt(i);
            if(c == 'S'){
                y--;
            }else if(c == 'N'){
                y++;
            }else if(c == 'W'){
                x--;
            }else{
                x++;
            }
        }

        int x2 = x*x;
        int y2 = y*y;

        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String args[]){
        String str = "WNEENESENNN";
        System.out.println(getShortestPath(str));

    }
}
