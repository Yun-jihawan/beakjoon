import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hardChess {
    static boolean[][] arr;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W')
                    arr[i][j] = true;
                else
                    arr[i][j] = false;
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i,j);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        boolean BW = arr[x][y];
        int count =0;
        int end_x =x+8;
        int end_y = y+8;

        for(int i=x;i<end_x;i++){
            for(int j =y;j<end_y;j++){
                if(BW!=arr[i][j]){
                    count++;
                }
                BW =(!BW);
            }
            BW=(!BW);
        }
        if(count>(64 - count))
            count = 64-count;
        if(count<min)
            min=count;
    }
}
