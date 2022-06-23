import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hardStar {
    static String[][] star ;
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        star = new String[N][N];

        pattern(0,0,N,false);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void pattern(int x,int y,int N,boolean blank){

        if(blank){
            for(int i=x ;i<x+N;i++){
                for(int j=y; j<y+N;j++){
                    star[i][j]=" ";
                }
            }
            return;
        }

        if(N==1){
            star[x][y]="*";
            return;
        }

        else{
            int size = N/3;
            int count =0;
            for(int i=x;i<x+N;i+=size){
                for(int j=y;j<y+N;j+=size){
                    count++;
                    if(count==5)
                        pattern(i,j,size,true);
                    else
                        pattern(i,j,size,false);
                }
            }
        }
    }
}

