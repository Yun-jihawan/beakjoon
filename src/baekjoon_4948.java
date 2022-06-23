import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_4948 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N!=0){
            if(N==1)
                System.out.println("1");
            else {
                System.out.println(decimal(N));
            }
            N = Integer.parseInt(br.readLine());
        }
    }

    static int decimal(int N){
        boolean [] table = new boolean[2*N+1];
        Arrays.fill(table,true);
        table[0] =false; table[1] = false;
        for(int i =2 ; i*i<=2*N;i++){
            if(table[i]){
                for(int j = i*i ; j<=2*N ; j+=i)
                    table[j] =false;
            }
        }
        int stack = 0;
        for(int i=N+1; i<=2*N; i++){
            if(table[i])
                stack++;
        }
        return stack;
    }
}
