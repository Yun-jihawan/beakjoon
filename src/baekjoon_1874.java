import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_1874 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        for(int i=0;i<N;i++)
            seq[i] = Integer.parseInt(br.readLine());

        int count = 1;

        for(int i=0;i<N;i++){

            if(stack.empty()){
                stack.push(count++);
                sb.append("+").append("\n");
            }

            while(stack.peek()<seq[i]){
                sb.append("+").append("\n");
                stack.push(count++);
            }

            if(stack.peek()==seq[i]){
                sb.append("-").append("\n");
                stack.pop();
            }

            else{
                System.out.println("NO");
                System.exit(0);
            }

        }

        System.out.println(sb);
    }
}
