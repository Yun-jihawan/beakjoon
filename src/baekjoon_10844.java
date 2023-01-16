import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10844 {
    static int N;
    static int[][]arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][10];
        int sum = 0;
        for(int i=1;i<=9;i++){

            sum=sum%1000000000+stair(N,i)%1000000000;
        }
        System.out.println(sum%1000000000);

    }
    static int stair(int depth,int number) {
        if (depth == 1) {
            arr[depth][number] = 1;
        }
        if (arr[depth][number] != 0)
            return arr[depth][number]%1000000000;
        else {
            if (number == 0) {
                arr[depth][number] = stair(depth - 1, number + 1) % 1000000000;
            } else if (number == 9) {
                arr[depth][number] = stair(depth - 1, number - 1) % 1000000000;
            } else {

                arr[depth][number] = (stair(depth - 1, number - 1) + stair(depth - 1, number + 1)) % 1000000000;
            }
        }
        return arr[depth][number]%1000000000;
    }

    public static class backjoon2164 {
        public static void main(String[] args)throws IOException{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int[] list = new int[2000000];

            int N = Integer.parseInt(bufferedReader.readLine());
            for(int i=1;i<=N;i++){
               list[i]=i;
            }

            int first = 1;
            int end = N;
            int change=0;

            while(end-first!=0){
                list[first]=0;
                change = list[first+1];
                first=first+2;
                list[end+1]=change;
                end++;
            }

            System.out.println(list[first]);


        }
    }
}
