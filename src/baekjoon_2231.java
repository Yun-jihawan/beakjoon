import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2231 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int copy =N;int size =0;

        while(copy!=0){
            size ++;
            copy = copy/10;
        }
        if(size ==1){
            for(int i=0;i<N;i++){
                if(i+i==N){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("0");
            return;
        }

        size = (size)*9;

        for(int i=N-size;i<N;i++){
            copy = i;
            int sum =i;
            while(copy!=0){
                sum += copy%10;
                copy = copy/10;
            }
            if(sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }
}
