import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1149 {
    static int arr[][];
    static int N;
    static int DP[][];
    static int red = 0; static int green =1; static int blue = 2;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        DP = new int[N][3];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        DP[0][red] = arr[0][red];
        DP[0][green] = arr[0][green];
        DP[0][blue] = arr[0][blue];

        System.out.println(Math.min(road(N-1,red),Math.min(road(N-1,green),road(N-1,blue))));
    }

    static int road(int depth,int color) {

        if(DP[depth][color]==0) {

            if (color == red) {
                DP[depth][red] = Math.min(road(depth - 1, green), road(depth - 1, blue)) + arr[depth][red];
            } else if (color == green) {
                DP[depth][green] = Math.min(road(depth - 1, red), road(depth - 1, blue)) + arr[depth][green];
            } else
                DP[depth][blue] = Math.min(road(depth - 1, red), road(depth - 1, green)) + arr[depth][blue];
        }
        return DP[depth][color];
    }
}
