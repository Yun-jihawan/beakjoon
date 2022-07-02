import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class baekjoon_10815 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet hashSet = new HashSet();

        while(st.hasMoreTokens()){
            hashSet.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            if(hashSet.contains(Integer.parseInt(st.nextToken())))
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);

    }
}
