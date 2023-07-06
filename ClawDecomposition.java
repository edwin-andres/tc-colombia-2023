import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ClawDecomposition {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer buf = new StringBuffer();
    static StringTokenizer st;
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean bipartite; 

    public static void main(String[] args) throws Exception {
        while (true) {
            N = Integer.parseInt(in.readLine());
            if (N==0) break;
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
            while (true) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (a==0) break;
                a--; b--;
                adj[a].add(b);
                adj[b].add(a);
            }
            solve();
        }
        System.out.print(buf);
    }
    
    static void bfs(int s, int[] d, int[] pred) {
        d[s] = 0;
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(s);
        while (!Q.isEmpty()) {
            int u = Q.poll();
            for(int v:adj[u]) {
                if (d[v]!=-1) {
                    if (v!=pred[u] && d[u]%2==d[v]%2) bipartite = false; 
                    continue;
                }
                d[v] = d[u] + 1;
                pred[v] = u;
                Q.add(v);
            }
        }
    }

    static void solve() {
        int[] d = new int[N];
        int[] pred = new int[N];
        Arrays.fill(d, -1);
        Arrays.fill(pred, -1);
        bipartite = true;
        for(int i=0; i<N; i++)
            if (d[i]==-1) 
                bfs(i, d, pred);
        if (bipartite) buf.append("YES\n");
        else buf.append("NO\n");      
    }
}
