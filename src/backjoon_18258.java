import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon_18258 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyQueue myQueue = new MyQueue();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String input;
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            input=st.nextToken();
            switch (input){
                case "push":
                    myQueue.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    stringBuilder.append(myQueue.pop()).append("\n");
                    break;

                case "size":
                    stringBuilder.append(myQueue.size()).append("\n");
                    break;

                case "empty":
                    stringBuilder.append(myQueue.empty()).append("\n");
                    break;

                case "front":
                    stringBuilder.append(myQueue.front()).append("\n");
                    break;

                case "back":
                    stringBuilder.append(myQueue.back()).append("\n");
                    break;
            }

        }

        System.out.println(stringBuilder);
    }
}

class MyQueue{
    private int first=0;
    private int end=0;
    private int[] list = new int[2000000];
    public void push(int X){
        if(end-first==0)
            list[first]=X;
        list[end]=X;
        end++;
    }
    public int pop(){
        if(end-first==0)
            return -1;
        int ret = list[first];
        list[first]=0;
        first++;
        return ret;
    }

    public int size(){
        return end-first;
    }

    public int empty(){
        if(end-first!=0)
            return 0;

        return 1;
    }

    public int front(){
        if(end-first==0)
            return -1;
        return list[first];
    }

    public int back(){
        if(end-first==0)
            return -1;
        return list[end-1];
    }

}
