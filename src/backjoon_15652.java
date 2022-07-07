import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_15652 {
    static int N; static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        back(0);
        System.out.println(sb);

    }
    static void back(int stack){
        if(stack == M){
            for(int i= 0;i<M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<N;i++){
            if(stack!=0&& arr[stack-1]>i+1)
                continue;
            arr[stack] = i+1;
            back(stack+1);
        }
    }
}
