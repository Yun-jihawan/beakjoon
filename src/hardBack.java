import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//point : 2차원배열을 1차원배열로 바꾸는 방법
public class hardBack {
    static int[] board;
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();

        board = new int[N];
        back(0);
        System.out.println(count);
    }

    static void back(int stack) {
        if (stack == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[stack] = i;
            if (check(stack)) {
                back(stack+1);
            }
        }
    }

    static boolean check(int stack) {
        for (int i = 0; i < stack; i++) {
            if(board[stack] == board[i])
                return false;
            else if(Math.abs(stack-i)==Math.abs(board[stack] - board[i]))
                return false;
        }
        return true;
    }
}
