import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hardDevil {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N==1)
            System.out.println("666");
        else
            find(N);
    }
    static void find(int N){
        int count = 1;
        int prev_num =0;
        int num =0;

        while(true){

            if((prev_num%10000)/10==666&&(prev_num%10)!=6){
                for(int i=0;i<1000;i++) {
                    if (count == N) {
                        System.out.println(prev_num*1000+num);
                        return;
                    }
                    num++;
                    count++;
                }
                prev_num++;
            }

            else if((prev_num%1000)==666){
                num=0;
                for(int i=0;i<1000;i++){
                    if(count==N){
                        System.out.println(prev_num*1000+num);
                        return;
                    }
                    num++;
                    count++;
                }
                prev_num++;
            }
            else if(prev_num%100==66){
                num=600;
                for(int i=0;i<100;i++){
                    if(count==N){
                        System.out.println(prev_num*1000+num);
                        return;
                    }
                    num++;
                    count++;
                }
                prev_num++;
            }
            else if(prev_num%10 == 6){
                num=660;
                for(int i=0;i<10;i++){
                    if(count==N){
                        System.out.println(prev_num*1000+num);
                        return;
                    }
                    num++;
                    count++;
                }
                prev_num++;
            }
            else{
                num=666;
                if(count==N){
                    System.out.println(prev_num*1000+num);
                    return;
                }
                count++;
                prev_num++;
            }
        }
    }
}
