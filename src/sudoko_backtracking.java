import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sudoko_backtracking {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];
        //입력 값 받기
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0);
    }

    //재귀 호출부
    static void back(int row, int col) {
        if (col == 9) {
            back(row + 1, 0);
            return;
        }
        //  다 채웠다면 출력후 프로그램 종료
        if (row == 9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <=9; i++) {
                if (possibility(row, col, i)) {
                    arr[row][col] = i;  // i 값을 채워넣고 다음 재귀 호출
                    back(row,col+1);
                }
            }
            arr[row][col] = 0; // 만약 더 채워질 수 없는 상황이 오면 돌아와서 채운 값을 없애고 상위 호출자로 복귀
            return;
        }
        back(row, col + 1); // 0이 아니라면 바로 넘어가기


    }

    static boolean possibility(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value)
                return false;
        }

        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (arr[i][j] == value)
                    return false;
            }
        }
        return true;
    }

}
