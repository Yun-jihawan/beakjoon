import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Shortestpath {

    static int P[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("n 값은? : ");
        int n = Integer.parseInt(br.readLine());
        final int W[][] = new int[n+1][n+1];
        int D[][] = new int[n+1][n+1];
        P = new int[n+1][n+1];

        //W배열 초기 설정
        System.out.println("경로 값을 입력하세요.");
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //D배열, P배열에 최단거리,최단경로 값을 채우기
        floyd2(n, W, D);

        //D배열, P배열 출력
        printArr(n, D, P);

        // 최단경로 출력
        System.out.print("찾으려는 최단경로의 출발지는? : ");
        int q = Integer.parseInt(br.readLine());
        System.out.print("찾으려는 최단경로의 목적지는? : ");
        int r = Integer.parseInt(br.readLine());
        path(q,r);
    }

    static void floyd2(int n, final int W[][], int D[][]) {

        int i, j, k;

        for (i = 1; i <= n; i++)
            for (j = 1; j <= n; j++) {
                P[i][j] = 0;
                D[i][j] = W[i][j];
            }
        for (k = 1; k <= n; k++)
            for (i = 1; i <= n; i++)
                for (j = 1; j <= n; j++) {
                    if(i==j)
                        continue;
                    else if (D[i][k] + D[k][j] < D[i][j]) {
                        P[i][j] = k;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
    }

    static void printArr(int n, int D[][], int P[][]) {
        StringBuilder sb = new StringBuilder();

        sb.append("D배열\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(D[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append("P배열\n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(P[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void path(int q, int r) {
        if (P[q][r] != 0) {
            path(q, P[q][r]);
            System.out.print("V"+P[q][r]);
            path(P[q][r], r);
        }
    }
}