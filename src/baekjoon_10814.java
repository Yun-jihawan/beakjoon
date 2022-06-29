import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Member{
    private int age;
    private String name;

    public Member(int age, String name){
        this.age=age;this.name=name;
    }
    public int getAge(){
        return this.age;
    }
    @Override
    public String toString(){
        return age+" "+name;
    }
}

public class baekjoon_10814 {
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Member[] arr = new Member[N];
        int[] counting = new int[201];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i]= new Member(Integer.parseInt(st.nextToken()),st.nextToken());

            counting[arr[i].getAge()]++;
        }
        for(int i=1;i<counting.length;i++)
            counting[i]+=counting[i-1];

        Member[] res = new Member[N];
        for(int i=N-1;i>=0;i--){
            counting[arr[i].getAge()]--;
            res[counting[arr[i].getAge()]] = arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N;i++)
            sb.append(res[i]).append("\n");
        System.out.println(sb);
    }
}
