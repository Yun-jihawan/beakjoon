import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1912 {
    static int N;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        bigNum(0,0,-1000);


    }
    static void bigNum(int depth,int max,int prev_max){
        if(depth ==N){
            System.out.println(prev_max);
            System.exit(0);
        }

        max += arr[depth];
        if(prev_max<max)
            prev_max = max;
        if(max<0){
            bigNum(depth+1,0,prev_max);
        }
        else{
            bigNum(depth+1,max,prev_max);
        }
    }
}
