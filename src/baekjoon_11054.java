import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11054 {
    static int N;
    static int[] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new Integer[N + 1][2];

        //초기값 설정
        dp[N][0] = 1;
        dp[N][1] = 1;
        arr[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(Math.max(binary(0, 0), binary(0, 1))-1);
    }

    static int binary(int depth, int ud) {
        //값이 없다면
        if (dp[depth][ud] == null) {

            int[] res = new int[N + 1];
            int j = 1;

            //ud ==0, 즉 증가 수열일때
            if (ud == 0) {
                for (int i = depth + 1; i < res.length; i++) {
                    if (arr[depth] < arr[i]) {
                        res[j] = i;
                        j++;
                    }
                }

                if (j == 1) {
                    dp[depth][ud] = 1;
                    return dp[depth][ud];
                }

                //증가 수열과 감소수열중 큰 값 지니기
                dp[depth][ud] = Math.max(binary(res[1], 0), binary(res[1], 1)) + 1;

                for (int i = 2; i < j; i++) {
                    dp[depth][ud] = Math.max(dp[depth][ud], Math.max(binary(res[i], 0), binary(res[i], 1)) + 1);
                }
            }

            //ud ==1, 즉 감소 수열일때
            else {
                for (int i = depth + 1; i < res.length; i++) {
                    if (arr[depth] > arr[i]) {
                        res[j] = i;
                        j++;
                    }
                }
                if (j == 1) {
                    dp[depth][ud] = 1;
                    return dp[depth][ud];
                }

                //가장 큰 감소수열을 찾기
                dp[depth][ud] = binary(res[1], 1) + 1;

                for (int i = 2; i < j; i++) {
                    dp[depth][ud] = Math.max(dp[depth][ud], binary(res[i], 1) + 1);
                }
            }
        }
        return dp[depth][ud];
    }
}
