import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "+|-", true);

        int sum = Integer.parseInt(st.nextToken());
        boolean TF = true;

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.equals("+")) {
                if(!TF){
                    sum -= Integer.parseInt(st.nextToken());
                }
                else{
                    sum += Integer.parseInt(st.nextToken());
                }
            }
            else if (str.equals("-")) {
                sum -= Integer.parseInt(st.nextToken());
                TF = false;
            }
        }
        System.out.println(sum);
    }

}
