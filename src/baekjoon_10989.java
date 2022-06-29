import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10989 {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] counting = new int[10001];
        int[] res = new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
            counting[arr[i]]++;
        }

        for(int i=1;i<10001;i++){
            counting[i] += counting[i-1];
        }

        int value=0;
        for(int i=N-1;i>=0;i--){
            value =arr[i];
            counting[value]--;
            res[counting[value]] = value;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
    }
}
