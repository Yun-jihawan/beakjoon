import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11053 {
    static int[] arr;
    static Integer[] dp;
    static int M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        arr = new int[M+1];
        dp = new Integer[M+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=1;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        arr[0] = 0;
        dp[M] =1;

        System.out.println(find(0)-1);

    }
    static int find(int N){
        if(dp[N]==null){
            int j=1;
            int[] res = new int[M+1];
            for(int i=N+1; i<dp.length;i++){
                if(arr[N]<arr[i]) {
                    res[j] = i;
                    j++;
                }
            }
            if(j==1) {
                dp[N] = 1;
            }
            else {
                dp[N] = find(res[1]) + 1;
                for (int i = 2; i < j; i++) {
                    dp[N] = Math.max(dp[N], find(res[i]) + 1);
                }
            }
        }
        return dp[N];
    }
}