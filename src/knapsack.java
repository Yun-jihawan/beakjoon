import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class knapsack {

    static int W;
    static int maxprofit;
    static int []p;
    static int []w;
    static int n;
    static int numbest;
    static String[] bestset;
    static String[] include;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("아이템의 수는? : ");
        n = Integer.parseInt(br.readLine());

        System.out.print("배낭에 넣을 수 있는 최대치는? : ");
        W = Integer.parseInt(br.readLine());

        include = new String[n+1];
        bestset = new String[n+1];
        for(int i=1;i<=n;i++){
            bestset[i] = null;
        }

        p = new int[n+1];
        w = new int[n+1];

        StringTokenizer stringTokenizer;
        for(int i=1;i<=n;i++){
            System.out.println(i+"번째 물건의 가치와 무게를 입력하세요");
            stringTokenizer = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(stringTokenizer.nextToken());
            w[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        knapsack(0,0,0);
        int i=1;
        while(i<=numbest &&bestset[i]!=null){
            System.out.print(bestset[i]+ " ");
            i++;
        }
    }

    static void knapsack(int i, int profit, int weight){
        if(weight<=W && profit > maxprofit){
            maxprofit = profit;
            numbest = i;
            for(int j =1; j<=i; j++) {
                bestset[j] = include[j];
            }

        }
        if(promising(i,profit,weight)){
            include[i+1] = "YES";
            knapsack(i+1,profit+p[i+1], weight+w[i+1]);
            include[i+1]="NO";
            knapsack(i+1,profit,weight);
        }
    }

    static boolean promising(int i, int profit, int weight){
        int j,k; int totweight; float bound;
        if(weight >= W) return false;
        else{
            j = i+1;
            bound = profit;
            totweight = weight;
            while((j<=n) && (totweight + w[j]  <= W)){
                totweight = totweight +w[j];
                bound = bound +p[j];
                j++;
            }
            k=j;
            if(k<=n)
                bound= bound + (W-totweight)*p[k]/w[k];
            return bound>maxprofit;
        }
    }
}
