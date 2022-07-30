import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11047 {

    static int[] arr;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (K == 0)
                break;
            else if (K - arr[i] < 0)
                continue;
            else {
                K = K - arr[i];
                res++;
                i++;
            }
        }

        System.out.println(res);
    }

}
