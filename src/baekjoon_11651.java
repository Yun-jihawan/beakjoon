import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point2{
    private int x;
    private int y;
    public Point2(int x, int y){
        this.x= x; this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class baekjoon_11651 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point2[] arr = new Point2[N];
        int[] counting = new int[200001];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point2 p = new Point2(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            arr[i] = p;
            counting[arr[i].getX()+100000]++;
        }

        for(int i=1;i< counting.length;i++){
            counting[i] += counting[i-1];
        }

        Point2[] res = new Point2[N];
        for(int i=N-1;i>=0;i--){
            counting[arr[i].getX()+100000]--;
            res[counting[arr[i].getX()+100000]]=arr[i];
        }

        for(int i=0;i<counting.length;i++)
            counting[i]=0;

        for(int i=0;i<N;i++){
            counting[res[i].getY()+100000]++;
        }
        for(int i=1;i< counting.length;i++)
            counting[i]+=counting[i-1];
        for(int i=N-1;i>=0;i--){
            counting[res[i].getY()+100000]--;
            arr[counting[res[i].getY()+100000]]=res[i];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(arr[i].toString()).append("\n");
        }
        System.out.println(sb);

    }
}
