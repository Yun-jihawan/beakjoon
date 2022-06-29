import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon_1427 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        int stack=0;
        while(num!=0){
            arr[stack] = num%10;
            num = num/10;
            stack++;
        }

        int temp=0;

        for(int i=0;i<stack-1;i++){
            for(int j=i+1;j<stack;j++){
                if(arr[i]<arr[j]){
                   temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
                }
            }
        }
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<stack;i++){
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
