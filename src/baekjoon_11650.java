import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point{
    private int x;
    private int y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public boolean compare(Point p){
        if(this.x>p.x)
            return true;
        else if (this.x<p.x)
            return false;
        else if(this.x==p.x&&this.y>p.y)
            return true;
        else
            return false;
    }

    public String print(){
        return this.x+" "+this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


public class baekjoon_11650 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];
        int[] counting = new int[200001];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point p = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            arr[i] = p;
            counting[arr[i].getY()+100000]++;
        }
        for(int i=1;i< counting.length;i++){
            counting[i] +=counting[i-1];
        }
        int value=0;
        Point[] res = new Point[N];

        for(int i=N-1;i>=0;i--){
            value = arr[i].getY();
            counting[value+100000]--;
            res[counting[value+100000]] = arr[i];
        }


        for(int i=0;i< counting.length;i++){
            counting[i] =0;
        }
        for(int i=0;i<N;i++){
            counting[res[i].getX()+100000]++;
        }
        for(int i=1;i< counting.length;i++){
            counting[i] +=counting[i-1];
        }

        for(int i=N-1;i>=0;i--){
            value = res[i].getX();
            counting[value+100000]--;
            arr[counting[value+100000]] = res[i];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(arr[i].print()).append("\n");
        }
        System.out.println(sb);
    }
}
