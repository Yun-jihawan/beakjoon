import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2775 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++){
            int floor=Integer.parseInt(br.readLine());
            int roomNum = Integer.parseInt(br.readLine());
            System.out.println(house(floor,roomNum));
        }
    }

    static int house(int k,int n){
        if(k==0)
            return n;
        else{
            int sum =0;
            for(int i=1;i<=n;i++){
                sum += house(k-1,i);
            }
            return sum;
        }
    }
}
