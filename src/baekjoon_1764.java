import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_1764 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        for(int i=0;i<N;i++){
            hashSet.add(br.readLine());
        }

        int stack=0;StringBuilder sb = new StringBuilder();
        String[] res = new String[M];
        for(int i=0;i<M;i++){
            String input = br.readLine();
            if(hashSet.contains(input)){
                res[stack] = input;
                stack++;
            }
        }

        String[] aa = new String[stack];
        for(int i=0;i<stack;i++){
            aa[i]=res[i];
        }
        Arrays.sort(aa);
        sb.append(stack).append("\n");
        for(int i=0;i<stack;i++){
            if(aa[i]==null)
                break;
            sb.append(aa[i]).append("\n");
        }
        System.out.print(sb);
    }
}
