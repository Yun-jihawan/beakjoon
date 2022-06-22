import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Stack {

    static int[] stack;
    static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        stack = new int[num];

        StringTokenizer st;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    static void push(int x) {
        stack[size] = x;
        size++;
    }

    static int pop() {
        if (size == 0)
            return -1;
        else {
            int ret = stack[size - 1];
            size--;
            return ret;
        }
    }

    static int size() {
        return size;
    }

    static int empty() {
        if (size == 0)
            return 1;
        else
            return 0;
    }

    static int top() {
        if (size == 0)
            return -1;
        else
            return stack[size - 1];
    }
}
