import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class baekjoon_1620 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer,String> hashMap = new HashMap<>();
        HashMap<String,Integer> hashMap2 = new HashMap<>();
        for(int i=1;i<=N;i++){
            String read = br.readLine();
            hashMap.put(i,read);
            hashMap2.put(read,i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            String s =br.readLine();
            if(s.charAt(0)>=65 && s.charAt(0)<=90){
                sb.append(hashMap2.get(s)).append("\n");
            }
            else
                 sb.append(hashMap.get(Integer.parseInt(s))).append("\n");
        }
        System.out.println(sb);
    }
}
