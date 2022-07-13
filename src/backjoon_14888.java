import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14888 {
    static int[] arr;
    static int[] box = new int[4];
    static int Max = -1000000000;
    static int Min = 1000000000;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        back(1,arr[0]);
        System.out.println(Max);
        System.out.println(Min);
    }
    static void back(int count, int sum){
        int prev_sum=sum;
        if(count == N){
            compare(sum);
            return;
        }

        if(box[0]!=0){
            sum += arr[count];
            box[0]--;
            back(count+1,sum);
            sum = prev_sum;
            box[0]++;
        }
        if(box[1]!=0){
            sum -= arr[count];
            box[1]--;
            back(count+1,sum);
            sum = prev_sum;
            box[1]++;
        }
        if(box[2]!=0){
            sum *= arr[count];
            box[2]--;
            back(count+1,sum);
            sum = prev_sum;
            box[2]++;
        }
        if(box[3]!=0){
            sum /= arr[count];
            box[3]--;
            back(count+1,sum);
            sum = prev_sum;
            box[3]++;
        }
        return;
    }
    static void compare(int input){
        if(input> Max)
            Max = input;
        if(input< Min)
            Min = input;
    }
}
