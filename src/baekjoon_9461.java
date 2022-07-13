import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_9461 {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++)
            arr[i] = -1;


        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(padovan(input));
        }
    }

    static long padovan(int input) {
        if (input==0||input == 1 || input == 2 || input == 3) {
            arr[input] = 1;
            return arr[input];
        } else if (arr[input] != -1) {
            return arr[input];
        } else {
            arr[input] = padovan(input - 3) + padovan(input - 2);
            return arr[input];
        }
    }

}
