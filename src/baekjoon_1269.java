import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_1269 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> hashSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<A;i++){
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine()); int stack=0;
        for(int i=0;i<B;i++){
            int input =Integer.parseInt(st.nextToken());
            if(hashSet.contains(input))
                stack++;
        }
        System.out.println(A+B-(2*stack));
    }
}
