import java.util.ArrayList;
import java.util.Stack;

public class topological_sort {

    static ArrayList<Integer>[] adj;
    static int[] d, t;
    static int N;
    static int time;
    static Stack<Integer> tsort;

    static void dfs(int u) {
        d[u] = time++;
        for(int v:adj[u]) {
            if (d[v]!=0) continue;
            dfs(v);
        }    
        t[u] = time++;
        tsort.add(u);
    }

    static int[] top_sort() {
        d = new int[N];
        t = new int[N];
        time = 1;
        tsort = new Stack<>();
        for(int u=0; u<N; u++) 
            if (d[u]==0) dfs(u);
        int[] tsort_arr = new int[N];
        for (int i = 0; i < N; i++) 
            tsort_arr[i] = tsort.pop();
        return tsort_arr;
    }

}