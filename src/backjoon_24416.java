import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_24416 {
    static int fiboNum = 1;
    static int nacciNum = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        fibo(N);
        nacci(N);

        System.out.println(fiboNum+" "+nacciNum);

    }
    static int fibo(int M){
        if(M==1||M==2)
            return 1;
        else {
            fiboNum++;
            return(fibo(M-1)+fibo(M-2));
        }
    }

    static int nacci(int M){
        int[] arr = new int[M+1];
        arr[1] = 1; arr[2] = 1;
        for(int i=3;i<=M;i++){
            arr[i] = arr[i-1]+arr[i-2];
            nacciNum++;
        }
        return arr[M];
    }
}
