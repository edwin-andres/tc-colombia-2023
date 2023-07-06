import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static ArrayList<Integer>[] adj;

    static void bfs(int s, int[] d, int[] pred) {
        Arrays.fill(d, -1); 
        Arrays.fill(pred, -1);
        d[s] = 0;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for(int v:adj[u]) {
                if (d[v]!=-1) continue;
                d[v] = d[u] + 1;
                pred[v] = u;
                Q.add(v);
            }
        }
    }
}
