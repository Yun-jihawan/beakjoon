import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1392 {
    static int N;
    static int[][] arr;
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        res = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                res[i][j] = -1;
            }
        }


        res[0][0] = arr[0][0];
        int max = 0;
        for(int i=0;i<N;i++){
            if(max<road(N-1,i))
                max = road(N-1,i);
        }
        System.out.println(max);
    }

    static int road(int depth, int i) {

        if (res[depth][i] != -1)
            return res[depth][i];

        else {
            if (i == 0) {
                res[depth][i] = road(depth - 1, i) + arr[depth][i];
               }
            else if(i==depth)
                res[depth][i] = road(depth - 1, i-1) + arr[depth][i];
            else {
                res[depth][i] = Math.max(road(depth - 1, i - 1), road(depth - 1, i)) + arr[depth][i];
            }
        }
        return res[depth][i];
    }
}
