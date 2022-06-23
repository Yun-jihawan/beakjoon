import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10870 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));

    }
    static int fibo(int N){
        if(N==0)
            return 0;
        else if(N==1)
            return 1;
        else
            return fibo(N-1)+fibo(N-2);

    }
}
