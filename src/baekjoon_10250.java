import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10250 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for(int i=0;i<num;i++){
            st = new StringTokenizer(br.readLine());
            int floor = Integer.parseInt(st.nextToken());
            int roomNum = Integer.parseInt(st.nextToken());
            int customerNum = Integer.parseInt(st.nextToken());
            int stack =1;

            while(customerNum-floor >0){
                customerNum -=floor;
                stack++;
            }
            System.out.println(customerNum*100+stack);
        }
    }
}
