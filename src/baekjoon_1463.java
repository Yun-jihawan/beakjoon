import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1463 {
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        arr[1] = 1;
        System.out.println(numberOne(N)-1);
    }
    static int numberOne(int input){
        if(arr[input]!=0)
            return arr[input];
        else{
           if(input%6==0)
               arr[input] = Math.min(numberOne(input/3)+1,Math.min(numberOne(input/2)+1,numberOne(input-1)+1));
           else if(input%3==0)
               arr[input] = Math.min(numberOne(input/3)+1,numberOne(input-1)+1);
           else if(input%2==0)
               arr[input] = Math.min(numberOne(input/2)+1,numberOne(input-1)+1);
           else
               arr[input] = numberOne(input-1)+1;

           return arr[input];
        }
    }
}
