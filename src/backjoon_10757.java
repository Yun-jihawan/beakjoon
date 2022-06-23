import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class backjoon_10757 {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        BigInteger big_1 = new BigInteger(st.nextToken());
        BigInteger big_2 = new BigInteger(st.nextToken());

        big_1=big_1.add(big_2);
        System.out.println(big_1);
    }
}
