import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_대표문제 {
    static int[][] arr;
    static Integer[][]dp;
    static int K;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][2];
        dp = new Integer[N][K+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recur(N-1,K));
    }
    static int recur(int N,int kilo){
        if(N<0)
            return 0;
        if(dp[N][kilo] == null){
            if(arr[N][0]>kilo)
                dp[N][kilo] = recur(N-1,kilo);
            else{
                dp[N][kilo] = Math.max(recur(N-1,kilo),recur(N-1,kilo-arr[N][0])+arr[N][1]);
            }
        }
        return dp[N][kilo];
    }
}
