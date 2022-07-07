import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
////15649 백트래킹 기초 문제 문제
public class Backtraking {
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visit = new boolean[N];
        back(N,M,0);

    }
    static void back(int N,int M, int stack){
        if(stack==M){
            for(int i=0;i<M;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for(int i=0;i<N;i++){
            if(!visit[i]) {
                visit[i] = true;
                arr[stack] = i + 1;
                back(N, M, stack + 1);
                visit[i]=false;
            }
        }
    }
}