import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_9020 {
    static boolean []table;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int maxNum = 0;
        int [] arr = new int[testCase];

        for(int i=0;i<testCase;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(maxNum<arr[i])
                maxNum = arr[i];
        }
        table = new boolean[maxNum];
        decimal();
        int a=0,b=0;
        for(int i=0;i<testCase;i++){
            for(int j=0;j<arr[i]/2;j++){
                if(table[arr[i]/2 -j]&& table[arr[i]/2+j]){
                    sb.append(((arr[i]/2) -j)).append(" ").append(((arr[i]/2) + j)).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }


    static void decimal(){
        int N = table.length;
        table = new boolean[N+1];
        table[0] = false; table[1] =false;
        Arrays.fill(table,true);

        for(int i=2;i*i<=N;i++){
            if(table[i]){
                for(int j=i*i;j<=N;j+=i)
                    table[j] =false;
            }
        }
    }
}
