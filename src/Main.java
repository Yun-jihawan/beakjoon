import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numerator =1; int denominator=1;
        int num = Integer.parseInt(br.readLine());
        int plusNum = 1; int stack=0;

        for(int i=1;i<num;i++){
            if(stack==0&&numerator==1){
                denominator++;
                plusNum *=-1;
                stack=1;
                continue;
            }
            if(stack==0&&denominator==1){
                numerator++;
                plusNum *=-1;
                stack=1;
                continue;
            }
            denominator+=plusNum;
            numerator -=plusNum;
            stack =0;
        }
        System.out.println(numerator+"/"+denominator);

    }
}
