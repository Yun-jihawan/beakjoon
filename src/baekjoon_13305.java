import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_13305 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] load = new long[N-1];
        long[] oil = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            load[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            oil[i] = Integer.parseInt(st.nextToken());
        }

        long sum =0;
        long now_oil = oil[0];
        for(int i=0;i<N-1;i++){
            if(now_oil>oil[i]){
                now_oil = oil[i];
            }
            sum = sum+(now_oil*load[i]);
        }
        System.out.println(sum);

    }
}
