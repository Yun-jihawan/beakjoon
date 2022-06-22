import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class beakjoon_10926 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        sb.append(str).append("??!");
        System.out.println(sb);
    }
}
