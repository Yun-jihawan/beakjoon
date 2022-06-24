import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_11729 {
    static int stk=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        hanoi(N,1,2,3);

        System.out.println(stk);
        System.out.println(sb);

    }

    static void hanoi(int N, int start, int via ,int end){

        if(N==1){
            stk++;
            sb.append(start).append(" ").append(end).append("\n");
        }
        else{
            hanoi(N-1,start,end,via);
            hanoi(1,start,via,end);
            hanoi(N-1,via,start,end);
        }
    }
}
