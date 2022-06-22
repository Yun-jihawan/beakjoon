import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class baekjoon_18108 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(br.readLine());

        System.out.println(inputNumber-543);
    }
}