import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_2565_내방식아님 {
    static int[][] wire;
    static Integer[] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        wire = new int[N][2];
        dp = new Integer[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });



        int max =0;

        for(int i=0;i<N;i++)
            max = Math.max(max,recur(i));

        System.out.println(N-max);

    }
    static int recur(int N){

        if(dp[N]==null){

            dp[N] =1;

            for(int i=N+1;i<dp.length;i++){
                if(wire[N][1]<wire[i][1]){
                    dp[N] = Math.max(dp[N],recur(i)+1);
                }
            }
        }
        return dp[N];
    }
}