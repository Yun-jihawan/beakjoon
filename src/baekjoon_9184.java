import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_9184 {
    static int[] memo = new int[8421];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a;
        int b;
        int c;
        for (int i = 0; i < memo.length; i++)
            memo[i] = -1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1&&c==-1)
                break;
            else
                System.out.println("w("+a+", "+b+", "+c+") = "+w_function(a, b, c));
        }
    }

    static int w_function(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        if (a > 20 || b > 20 || c > 20)
            return w_function(20, 20, 20);
        else {
            int N = a * 20 * 20 + b * 20 + c;
            if (memo[N] != -1)
                return memo[N];
            else if (a < b && b < c) {
                memo[N] = w_function(a, b, c - 1) + w_function(a, b - 1, c - 1) - w_function(a, b - 1, c);
            } else {
                memo[N] = w_function(a - 1, b, c) + w_function(a - 1, b - 1, c) + w_function(a - 1, b, c - 1) - w_function(a - 1, b - 1, c - 1);
            }
            return memo[N];
        }
    }
}
