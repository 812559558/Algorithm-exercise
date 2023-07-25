package codefun2000;

import java.util.*;

public class p1029 {
    static List<Map<Integer, Integer>> edges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] indeg = new int[n + 1];
        indeg[0] = 999;
        int[] PRO = new int[n + 1];
        edges = new ArrayList<>();
        edges.add(new HashMap<>());
        for (int i = 0; i < n; i++) {
            edges.add(new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            Map<Integer, Integer> map = edges.get(b);//取最大的
            if (map.containsKey(a)) {
                if (map.get(a) < c) {
                    map.put(a, c);
                }
            } else {
                map.put(a, c);
            }
            indeg[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (indeg[i] == 0) {

                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (Map.Entry<Integer, Integer> entry : edges.get(i).entrySet()) {
                --indeg[entry.getKey()];
                PRO[entry.getKey()] = PRO[entry.getKey()] > PRO[i] + entry.getValue() ? PRO[entry.getKey()] : PRO[i] + entry.getValue();
                if (indeg[entry.getKey()] == 0) {
                    queue.offer(entry.getKey());
                }
            }
        }
        int[][] ints = new int[n][2];
        for (int i = 1; i < n + 1; i++) {
            ints[i - 1][0] = i;
            ints[i - 1][1] = PRO[i];
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.print(ints[i][0]+" ");
        }
    }

}
