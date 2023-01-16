import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

class Nodetype{
    int parent;
    int depth;
}
class DisjointSetDataStructure2 {
    Nodetype[] U;

    public DisjointSetDataStructure2(int n){
        U = new Nodetype[n+1];
    }


    void makeset(int i) {
        U[i] = new Nodetype();
        U[i].parent = i;
        U[i].depth = 0;
    }

    int find(int i) {
        int j = i;
        while (U[j].parent != j)
            j = U[j].parent;

        return j;
    }

    void merge(int p, int q) {
        if (U[p].depth == U[q].depth) {
            U[p].depth += 1;
            U[q].parent = p;
        } else if (U[p].depth < U[q].depth) {
            U[p].parent = q;
        } else
            U[q].parent = p;
    }

    boolean equal(int p, int q) {
        if (p == q) return true;
        else return false;
    }

    void initial(int n) {
        for (int i = 1; i <= n; i++)
            makeset(i);
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        System.out.print("Node 수 : ");
        int n = Integer.parseInt(br.readLine());

        System.out.print("Edge 수 : ");
        int m = Integer.parseInt(br.readLine());

        int[][] edge = new int[n + 1][n + 1];

        System.out.println("가중치 배열 입력");
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                edge[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        kruskal(n, m, edge);

    }

    static void kruskal(int n, int m, int[][] edge) {
        int p, q;

        //정렬
        String[] str = new String[m + 1];
        int[] weight = new int[m + 1];
        int k = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if(edge[i][j]!=99999) {
                    str[k] = i + "," + j;
                    weight[k] = edge[i][j];
                    k++;
                }
            }
        }
        int tmp = 0;
        String S;
        for (int i = 1; i < m; i++) {
            for (int j = i + 1; j < m + 1; j++) {
                if (weight[i] > weight[j]) {
                    tmp = weight[i];
                    weight[i] = weight[j];
                    weight[j] = tmp;

                    S = str[i];
                    str[i] = str[j];
                    str[j] = S;
                }
            }
        }
        HashSet<String> F = new HashSet<>();
        DisjointSetDataStructure2 U = new DisjointSetDataStructure2(n);
        U.initial(n);

        k=1; StringTokenizer st; int size=0;

        while (size < n - 1) {
            st = new StringTokenizer(str[k],",");
            k++;
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            p = U.find(i);
            q = U.find(j);
            if (!U.equal(p, q)) {
                U.merge(p, q);
                F.add("(V" + i + ", V" + j + ")");
                size++;
            }
        }

        Iterator<String> it = F.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}