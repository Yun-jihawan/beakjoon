import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] table = new boolean[N+1];
        Arrays.fill(table,true);
        table[0]=false;table[1]=false; //0,1은 소수가 아니므로 false

        StringBuilder sb = new StringBuilder();

        for(int i=2;i*i<=N;i++){  // 2부터 배수 빼기 시작 -> i*i값이 N값을 넘기 전까지만 한다
            if(table[i] ==true){
                for(int j=i*i;j<=N;j+=i)  // 왜 i*i하냐 ->i*2는 i=2일때 이미 계산, i*3은 i=3일때 이미 계산 ....
                    table[j] = false;
            }
        }

        for(int i=M;i<=N;i++)
            if(table[i]==true)
                sb.append(i).append("\n");
        System.out.println(sb);
    }
}
