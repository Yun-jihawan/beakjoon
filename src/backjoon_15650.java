import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_15650 {
    static int[] arr;
    static boolean[] visit;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
        back(N,M,0);

    }

    static void back(int N, int M, int stack) {
        if (stack == M) {
            for (int i = 0; i < M; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for(int i=count;i<N;i++){

            if(!visit[i]){
                if(stack !=0 && arr[stack -1]>i+1)
                    continue;
                visit[i] = true;
                arr[stack] = i+1;

                back(N,M,stack+1);
                visit[i] = false;
            }
            if(stack==0) {
                count++;
                for(int j=0;j<N;j++){
                    visit[j] = false;
                }
            }
        }
    }
}
