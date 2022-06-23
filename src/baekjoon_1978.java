import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1978 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());

        int stack=0;
        for(int i=0;i<size;i++){
            int check =0;
            int number = Integer.parseInt(st.nextToken());
            if(number ==1)
                continue;
            else{
                for(int j=2;j<number;j++){
                    if(number%j==0)
                        check++;
                }
                if(check==0)
                    stack++;
            }
        }
        System.out.println(stack);
    }
}
