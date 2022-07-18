import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2579 {
    static int N;
    static int[] arr;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        res = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        res[N][0] = arr[N];
        res[N][1] = arr[N];
        System.out.println(Math.max(riseUp(0, 0), riseUp(1, 0)));
    }

    static int riseUp(int depth, int stack) {

        if (stack == 2)
            return -1000;

        if (res[depth][stack] != 0) {
            return res[depth][stack];
        } else {
            if (depth == N -1) {
                res[depth][stack] = riseUp(depth + 1, stack + 1) + arr[depth];
            } else {
                res[depth][stack] = Math.max(riseUp(depth + 1, stack + 1), riseUp(depth + 2, 0)) + arr[depth];

            }
        }
        return res[depth][stack];

    }
}
