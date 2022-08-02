import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_10773 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());


        Stack stack = new Stack();

        for(int i=0;i<K;i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0)
                stack.pop();
            else{
                stack.push(input);
            }

        }
        int sum=0;
        while(!stack.empty()){
            sum+=(int)stack.pop();
        }
        System.out.println(sum);
    }

}
