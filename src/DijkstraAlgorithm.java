import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class DijkstraAlgorithm {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("n입력 : ");
        int n = Integer.parseInt(br.readLine());

        int [][]W = new int[n+1][n+1];

        System.out.println("w 배열 입력");
        StringTokenizer st;

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dijkstra(n,W);

    }

    static void dijkstra(int n, final int W[][]){

        int vnear=0;

        HashSet<String> F = new HashSet<>();

        int[] touch = new int[n+1];
        int[] length = new int[n+1];

        for(int i=2;i<=n;i++){
            touch[i] = 1;
            length[i] = W[1][i];
        }

        for(int K=1;K<n;K++){
            int min = 99999;
            for(int i=2; i<=n; i++)
                if(length[i]>=0 && length[i]<= min){
                    min = length[i];
                    vnear = i;
                }

            for(int i=2; i<=n; i++)
                if(length[vnear] + W[vnear][i] < length[i]){
                    length[i] = length[vnear] + W[vnear][i];
                    touch[i] = vnear;
                }

            F.add("{V"+touch[vnear]+", V"+vnear+"}");

            length[vnear]=-1;
        }
        Iterator<String> it = F.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
