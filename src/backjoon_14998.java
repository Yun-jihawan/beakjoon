import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_14998 {
    static int N; static int[][]arr;
    static int Min = 10000000;
    static boolean[] team;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        team= new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        soccer(0,0);
        StringBuilder sb = new StringBuilder();
        sb.append(Min);
        System.out.println(sb);
    }

    //재귀부
    static void soccer(int idx,int count){
        if(count==N/2){
            compare();
            return;
        }

        for(int i=idx;i<N;i++){
            if(!team[i]){
                team[i] = true;
                soccer(i+1,count+1);
                team[i] = false;
            }
        }
        return;
    }

    // Min 설정
    static void compare(){
        int myTeam=0;
        int yourTeam =0;
        int []soccerTeam = new int[N];
        for(int i=0;i<N;i++){

        }

        //우리팀 점수
        for(int i=0;i<N;i++){
            if(!team[i])
                continue;
            for(int j=0;j<N;j++){
                if(team[j]){
                    myTeam+= arr[i][j];
                }
            }
        }
        //상대팀 점수
        for(int i=0;i<N;i++){
            if(team[i])
                continue;
            for(int j=0;j<N;j++){
                if(!team[j]){
                    yourTeam+= arr[i][j];
                }
            }
        }
        if(Math.abs(myTeam-yourTeam)<Min)
            Min = Math.abs(myTeam-yourTeam);

    }
}
