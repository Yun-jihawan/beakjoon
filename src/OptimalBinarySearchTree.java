import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OptimalBinarySearchTree {
    static float []p;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("index 값 : ");
        int n = Integer.parseInt(br.readLine());

        p = new float[n+1];
        int[][] R = new int[n+2][n+1];

        StringTokenizer st;

        for(int i=1;i<=n;i++){
            System.out.print("key["+i+"]의 확률은? : ");
            st = new StringTokenizer(br.readLine(),"/");

            float sum = Float.parseFloat(st.nextToken())/Integer.parseInt(st.nextToken());
            p[i] =sum;
        }
        optsarchtree(n,R);
    }
    static void optsarchtree(int n, int R[][]) {

        int i, j, k, diagonal;
        float[][] A = new float[n + 2][n + 1];
        for(i=1;i<=n+1;i++){
            for(j=1;j<=n;j++)
                A[i][j]=99999;
        }

        for (i = 1; i <= n; i++) {
            A[i][i - 1] = 0;
            A[i][i] = p[i];
            R[i][i] = i;
            R[i][i - 1] = 0;
        }

        A[n + 1][n] = 0;
        R[n + 1][n] = 0;

        for (diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (i = 1; i <= n - diagonal; i++) {
                j = i + diagonal;

                float chance=0;

                for(k=i;k<=j;k++) {
                    chance += p[k];
                }
                for (k = i; k <= j; k++) {
                    if(A[i][j]>A[i][k-1]+A[k+1][j]+chance){
                        A[i][j] = A[i][k-1]+A[k+1][j]+chance;
                        R[i][j]=k;
                     }
                }
            }
        }

        System.out.println("A배열");
        for(i=1;i<=n+1;i++){
            for(j=0;j<=n;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println("R배열");
        for(i=1;i<=n+1;i++){
            for(j=0;j<=n;j++){
                System.out.print(R[i][j]+" ");
            }
            System.out.println();
        }

        System.out.print("최소 : ");
        System.out.println(A[1][n]);
    }
}
