import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class baekjoon_11478 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> hashSet = new HashSet<>();

        String input = br.readLine();
        char[] token = input.toCharArray();
        int stack=0;int count=0;
        while(stack<=token.length){
            for(int i=0; i<input.length()-stack;i++){
                String str = input.substring(i,i+stack+1);

                if(!hashSet.contains(str)){
                    hashSet.add(str);
                    count++;
                }
            }
            stack++;
        }
        System.out.println(count);

    }
}