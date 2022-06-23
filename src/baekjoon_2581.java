import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2581 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = 10000; int sum =0;

        for(int i=M;i<=N;i++){
            int check=0;
            for(int j=2;j<i;j++){
                if(i%j==0)
                    check++;
            }
            if(i!=1&&check==0){
                sum +=i;
                if(i<min)
                    min =i;
            }

        }
        if(sum==0)
            System.out.println("-1");
        else{
        System.out.println(sum);
        System.out.println(min);
        }
    }
}

