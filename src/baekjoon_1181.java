import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1181 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for(int i=0; i<N;i++){
            str[i] = br.readLine();
        }
        Arrays.sort(str);


        int[] counting = new int[51];
        for(int i=0;i<str.length;i++){
            counting[str[i].length()]++;
        }

        for(int i=1;i<counting.length;i++)
            counting[i] += counting[i-1];

        String[] res = new String[N];

        for(int i=N-1;i>=0;i--){
            counting[str[i].length()]--;
            res[counting[str[i].length()]] = str[i];
        }
        StringBuilder sb = new StringBuilder();
        String s = res[0];
        for(int i=0;i<N;i++) {
            if (i!=0&&s.equals(res[i])){
                s=res[i];
                continue;
            }
            sb.append(res[i]).append("\n");
            s=res[i];
        }
        System.out.println(sb);
    }
}
