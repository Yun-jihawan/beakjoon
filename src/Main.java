import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    static int[] Queue;
    static int size=0;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        Queue = new int[num];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<num;i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }

    static void push(int N){
        Queue[size] = N;
        size++;
    }

    static int pop(){
        if(size==0)
            return -1;
        else{
            int res = Queue[0];
            for(int i=0;i<size-1;i++){
                Queue[i] =Queue[i+1];
            }
            size--;
            return res;
        }
    }

    static int size(){
        return size;
    }

    static int empty(){
        if(size==0)
            return 1;
        else
            return 0;
    }

    static int front(){
        if(size==0)
            return -1;
        else{
            return Queue[0];
        }
    }

    static int back(){
        if(size==0)
            return -1;
        else{
            return Queue[size-1];
        }
    }
}