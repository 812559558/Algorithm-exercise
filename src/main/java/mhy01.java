import java.util.Scanner;

public class mhy01 {
    static int[][] mv = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] vis = new boolean[1010][1010];
    static boolean[][] vis2 = new boolean[1010][1010];
    static String[] strings = new String[1010];
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += dfs1(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt -= dfs2(i, j);
            }
        }
        System.out.println(cnt);
    }
    static public int dfs1(int x, int y) {
        if (x < 0 || x >= n) return 0;
        if (y < 0 || y >= m) return 0;
        if (vis[x][y]) return 0;
        if (!vis[x][y]) vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (x + mv[i][0] < 0 || x + mv[i][0] >= n) continue;
            if (y + mv[i][1] < 0 || y + mv[i][1] >= m) continue;
            if (strings[x + mv[i][0]].charAt(y + mv[i][1]) == strings[x].charAt(y)) {

                dfs1(x + mv[i][0], y + mv[i][1]);
            }
        }

        return 1;
    }

    static public int dfs2(int x, int y) {
        if (x < 0 || x >= n) return 0;
        if (y < 0 || y >= m) return 0;
        if (vis2[x][y]) return 0;
        if (!vis2[x][y]) vis2[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (x + mv[i][0] < 0 || x + mv[i][0] >= n) continue;
            if (y + mv[i][1] < 0 || y + mv[i][1] >= m) continue;
            if (strings[x + mv[i][0]].charAt(y + mv[i][1]) == strings[x].charAt(y)
                    || ((strings[x + mv[i][0]].charAt(y + mv[i][1]) == 'G' || strings[x + mv[i][0]].charAt(y + mv[i][1]) == 'B')
                    && (strings[x].charAt(y) == 'B' || strings[x].charAt(y) == 'G'))
            ) {
                dfs2(x + mv[i][0], y + mv[i][1]);
            }
        }

        return 1;
    }

}
