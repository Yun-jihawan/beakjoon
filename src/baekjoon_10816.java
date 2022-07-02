import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_10816 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            int input =Integer.parseInt(st.nextToken());

            if(hashMap.containsKey(input))
                hashMap.replace(input,hashMap.get(input)+1) ;
            else
                hashMap.put(input,1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int input = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(input))
                sb.append(hashMap.get(input)).append(" ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}
