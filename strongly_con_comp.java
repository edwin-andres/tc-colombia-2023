import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class strongly_con_comp {
    
    static int N;
    static ArrayList<Integer>[] adj;
    static Stack<Integer> top_sort;
    static int[] d, scc;
    static int time;
    static int nscc;

    static void dfs(int u) {
        d[u] = time++;
        for(int v:adj[u]) 
            if (d[v]==0) dfs(v);
        top_sort.push(u);
    }

    static void dfs_kos(int u) {
        scc[u] = nscc;
        d[u] = time++;
        for(int v:adj[u]) 
            if (d[v]==0) dfs_kos(v);
    }

    static ArrayList<Integer>[] transpose(ArrayList<Integer>[] adj) {
        ArrayList<Integer>[] adj2 = new ArrayList[N];
        for (int i = 0; i < N; i++) adj2[i] = new ArrayList<>();
        for (int i = 0; i < N; i++)
            for(int v:adj[i])
                adj2[v].add(i);
        return adj2;
    }

    static void strongly_cc() {
        d = new int[N];
        top_sort = new Stack<>();
        time = 1;
        for(int i=0; i<N; i++) 
            if (d[i]==0) dfs(i);
        scc = new int[N];
        nscc = 0;
        Arrays.fill(d, 0);
        Arrays.fill(scc, -1);
        adj = transpose(adj);
        while (!top_sort.isEmpty()) {
            int u = top_sort.pop();
            if (d[u]==0) {
                dfs_kos(u);
                nscc++;
            }
        }
    }
}
