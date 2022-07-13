import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1904 {
    static int N;
    static int[] blank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        blank = new int[N + 1];

        for (int i = 0; i < N+1; i++) {
            blank[i] = -1;
        }
        blank[0]= 1;
        blank[1] = 1;

        for(int i =2 ; i<=N;i++){
            blank[i] = (blank[i-1]+blank[i-2])%15746;
        }
        System.out.println(blank[N]);
    }
}
