import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hardSorting {
    static int[] arr;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //counting sort
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new int[N];
        int[] counting = new int[8001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            counting[arr[i] + 4000]++;
        }

        for (int i = 1; i < 8001; i++) {
            counting[i] += counting[i - 1];
        }
        int value = 0;

        for (int i = 0; i < N; i++) {
            value = arr[i];
            counting[value + 4000]--;
            res[counting[value + 4000]] = value;

        }


        StringBuilder sb = new StringBuilder();

        double avg = 0;

        for (int i = 0; i < N; i++) {
            avg += res[i];
        }
        avg = Math.round(avg/N);

        sb.append((int)avg).append("\n");

        sb.append(res[N / 2]).append("\n");

        int mode=0;
        int mode_max=0;
        boolean flag = false;

        for(int i=0;i<N;i++){
            int jump=0;
            int count =1;

            for(int j=i+1;j<N;j++){
                if(res[i] != res[j]){
                    break;
                }
                count++;
                jump++;
            }

            if(count>mode_max){
                mode_max = count;
                mode = res[i];
                flag = true;
            }

            else if ( count==mode_max && flag == true){
                mode = res[i];
                flag = false;
            }
            i += jump;
        }

        sb.append(mode).append("\n");

        sb.append(res[N - 1] - res[0]).append("\n");
        System.out.println(sb);
    }

}
