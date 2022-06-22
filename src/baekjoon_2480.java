import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class baekjoon_2480 {
    public static void main(String[] args)throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int []number = new int[4]; //맨앞은 가장 큰 값 삽입을 위해 한칸 늘려서 배열 생성
        int stack=0; int selectNum=0;

        for(int i=1;i<number.length;i++){ // 맨 앞을 제외하고 값 입력 받음
            number[i] = Integer.parseInt(st.nextToken());
        }

        number[0] =0; // 맨 앞칸 초기화

        for(int i=1;i<number.length;i++){
            if(number[0]<number[i])
                number[0]=number[i];
            for(int j=i+1;j<number.length;j++){
                if (i!=j&&number[i] == number[j]){
                    stack++;
                    selectNum = number[i];
                }
            }
        }
        if(stack==3){
            System.out.println(10000+selectNum*1000);
        }
        else if(stack ==1){
            System.out.println(1000+selectNum*100);
        }
        else
            System.out.println(100*number[0]);
    }
}
