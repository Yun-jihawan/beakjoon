import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {

    static Integer[][] dp;
    static char[] arr1;
    static char[] arr2;

    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        arr1 = br.readLine().toCharArray();
        arr2 = br.readLine().toCharArray();

        dp = new Integer[arr1.length][arr2.length];

        System.out.println(recur(arr1.length-1,arr2.length-1));
    }
    static int recur(int x,int y){

        if(x==-1||y==-1)
            return 0;

        if(dp[x][y]==null){
            if(arr1[x]==arr2[y])
                dp[x][y] = recur(x-1,y-1)+1;
            else
                dp[x][y] = Math.max(recur(x-1,y),recur(x,y-1));
        }
        return dp[x][y];
    }
}
