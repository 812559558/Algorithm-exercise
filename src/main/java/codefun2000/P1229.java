package codefun2000;

import java.util.*;

public class P1229 {
    static List<List<Integer>> edges;
    static int[] indeg;
    static int cnt = 0;
    static int index = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        edges = new ArrayList<>();
        edges.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            for (int j = 0; j < x; j++) {
                edges.get(scanner.nextInt()).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int u = q.poll();
                index++;
                for(int v:edges.get(u)){
                    indeg[v]--;
                    if (indeg[v] == 0) {
                        q.offer(v);
                    }
                }

            }
            cnt++;
        }
        if (index!=n) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

    }

}
