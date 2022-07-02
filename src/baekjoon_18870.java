import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_18870 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];// 원본 배열
        int[] sort = new int[N];// 정렬을 진행 한 배열
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sort[i] = arr[i];
        }

        Arrays.sort(sort);

        HashMap<Integer,Integer> hashMap = new HashMap<>(); // 중복된 값 키 동일 하기 때문에 순서있고 중복없는 해쉬맵 사용
        int count=0;
        for(int i=0;i<N;i++){
            if(!hashMap.containsKey(sort[i])) { // 키 값이 존재 안한다면
                hashMap.put(sort[i], count);
                count++;
            }
        }
        int[] rank = new int[N];

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<N;i++){
            rank[i] = hashMap.get(arr[i]);
            sb.append(rank[i]).append(" ");
        }
        System.out.println(sb);
    }
}
