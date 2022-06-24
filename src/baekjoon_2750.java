import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2750 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int []arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int temp=0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(arr[i]>arr[j]){
                    temp =arr[i];
                    arr[i] =arr[j];
                    arr[j] =temp;
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.println(arr[i]);
        }
    }
}
