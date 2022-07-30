import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_1931 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] room = new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            room[i][1] = Integer.parseInt(st.nextToken());
            room[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });

        //for(int i=0;i<N;i++)
        // System.out.println(room[i][0] +" "+room[i][1]);
        int now_end = room[0][0];
        int res=1; // now_end 설정 시 초기 값을 정했기 때문에 1로 시작

        for(int i = 1; i <N;i++){

            if(room[i][1]>=now_end){
                now_end = room[i][0];
                res++;
            }

        }
        System.out.println(res);
    }
}
