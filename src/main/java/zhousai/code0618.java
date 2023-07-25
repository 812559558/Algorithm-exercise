package zhousai;

import java.util.*;

public class code0618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();//缓存空间
        int X = scanner.nextInt();//url数量
        int[] urls = new int[X];
        for (int i = 0; i < X; i++) {
            urls[i] = scanner.nextInt();
        }
        int Y = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < Y; i++) {
            map.put(scanner.nextInt(),scanner.nextInt());

        }
        int[] ans = new int[X];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
                    }
                }
        );
        HashSet<Integer> cache = new HashSet<>();

        for (int i = 0; i < X; i++) {
            while (pq.size() > 0 && pq.peek()[1] <= i) {
                int[] rem = pq.poll();
                cache.remove(rem[2]);//因为这是优先级队列，ttl小的排在队头，所以过期的只会在队头，循环遍历队头过期就删除
            }
            if (cache.contains(urls[i])) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
                if (pq.size() == N) {
                    int[] rem = pq.poll();
                    cache.remove(rem[2]);
                }
                int[] add = new int[]{i, i + map.getOrDefault(urls[i], 5), urls[i]};
                pq.offer(add);
                cache.add(urls[i]);
            }
        }
        for (int t : ans) {
            System.out.println(t+" ");
        }
    }
}
