import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_2839 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        System.out.println(gram(input));

    }

    static int gram(int input){

        int number = 0;

        for(int i=(input/5);i>=0;i--){
            for(int j=0;j<(input/3)+1;j++){
                number = (5*i)+(3*j);
                if(input==number)
                    return i+j;
                else if(input<number)
                    break;
            }
        }

        return -1;
    }
}
