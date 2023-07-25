package greedy;

import java.util.*;

public class Solution {
    int x;
    int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public Solution() {
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        for (int i = 0, j = 0; i < s.length && j < g.length; ) {
            if (s[i] >= g[j]) {
                sum++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return sum;
    }

    public int wiggleMaxLength(int[] nums) {
        int result = 1;
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = nums[i + 1] - nums[i];
            if (pre <= 0 && cur > 0 || pre >= 0 && cur < 0) {
                result++;
                pre = cur;
            }
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                res = res > count ? res : count;
            }
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (res < count) res = count;
            if (count < 0) {
                count = 0;
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < prices.length - 1; i++) {
            list.add(prices[i + 1] - prices[i]);
        }
        int res = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                res += list.get(i);
            }
        }
        return res;
    }

    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    public int jump(int[] nums) {
        int ans = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(nums[i] + i, next);
            if (cur >= nums.length - 1) return ans;
            if (i == cur) {
                ans++;
                cur = next;
            }
        }
        return ans;
    }

    public int jump2(int[] nums) {
        if (nums.length == 1) return 0;
        int curDistance = 0;    // 当前覆盖最远距离下标
        int ans = 0;            // 记录走的最大步数
        int nextDistance = 0;   // 下一步覆盖最远距离下标
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance);  // 更新下一步覆盖最远距离下标
            if (i == curDistance) {                         // 遇到当前覆盖最远距离下标
                if (curDistance < nums.length - 1) {       // 如果当前覆盖最远距离下标不是终点
                    ans++;                                  // 需要走下一步
                    curDistance = nextDistance;             // 更新当前覆盖最远距离下标（相当于加油了）
                    if (nextDistance >= nums.length - 1) break; // 下一步的覆盖范围已经可以达到终点，结束循环
                } else break;                               // 当前覆盖最远距到达集合终点，不用做ans++操作了，直接结束
            }
        }
        return ans;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int x = k;
        for (int i = 0; i < k; i++) {
            if (nums[0] < 0) {
                nums[0] = -nums[0];
                Arrays.sort(nums);
            } else {
                nums[0] = -nums[0];
            }

        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int largestSumAfterKNegations2(int[] nums, int k) {
        Integer newNums[] = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] < 0 && k > 0) {
                newNums[i] = -newNums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            newNums[newNums.length - 1] *= -1;
        }
        int sum = 0;
        for (int i = 0; i < newNums.length; i++) {
            sum += newNums[i];
        }
        return sum;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
//从加油站往下一个走，汽油总量>cost[i]
//每个加油站点都试一遍
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int tank = 0;
            for (; j < j + gas.length; j++) {
                tank += gas[j % gas.length];
                if (tank < cost[j % gas.length]) {
                    break;
                }
            }
            if (j == j + gas.length) {
                return i;
            }

        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0;
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            System.out.println(sum);
            sum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                start = i + 1;
            }
        }
        if (curSum > 0) return start;
        if (sum < 0) {
            return -1;
        }
        return -1;
    }

    public boolean lemonadeChange(int[] bills) {
        int[] res = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) res[0] += 1;
            if (bills[i] == 10) {
                if (res[0] > 0) {
                    res[0]--;
                    res[1]++;
                } else {
                    return false;
                }
            }
            if (bills[i] == 20) {
                if (res[0] > 0) {
                    if (res[1] > 0) {
                        res[1]--;
                        res[0]--;
                    } else if (res[0] > 2) {
                        res[0] = res[0] - 3;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i < ratings.length - 1) {
                    if (ratings[i] > ratings[i + 1]) {
                        if (res[i] <= res[i + 1]) {
                            res[i]++;
                            flag = true;
                        }
                    }
                }
                if (i > 0) {
                    if (ratings[i] > ratings[i - 1]) {
                        if (res[i] <= res[i - 1]) {
                            res[i]++;
                            flag = true;
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);
        }
        return que.toArray(new int[people.length][]);
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        int result = 1;
        Arrays.sort(points, (a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                result++;
            } else {
                points[i][1] = Math.min(points[i][0], points[i - 1][1]);
            }

        }
        return result;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] > b[0] ? 1 : -1;
        });
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            System.out.println(intervals[i][0]);
            if (intervals[i][0] < intervals[i - 1][1]) {
                res++;
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return res;
    }

    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] hash = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;
            System.out.println(hash[s.charAt(i) - 'a']);
        }
        int len = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            len++;
            max = Math.max(hash[s.charAt(i) - 'a'], max);
            if (max == i) {
                res.add(len);
                len = 0;
            }
        }
        return res;
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.get(res.size())[1]) {
                res.get(res.size())[1] = Math.max(res.get(res.size())[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        res.toArray(new int[res.size()][]);
        return res.toArray(new int[res.size()][]);
    }

    public int monotoneIncreasingDigits(int n) {
        String[] strings = (n + "").split("");
        int start = strings.length;
        for (int i = strings.length; i > 0; i--) {
            if (Integer.parseInt((strings[i])) < Integer.parseInt(strings[i - 1])) {
                strings[i - 1] = (Integer.parseInt(strings[i - 1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.valueOf(strings));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == target) return true;

            }
        }
        return false;
    }

    public int[] leftRigthDifference(int[] nums) {
        int[] leftsum = new int[nums.length];
        int[] rightsum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                left += nums[j];
            }
            leftsum[i] = left;
        }
        for (int i = 0; i < nums.length; i++) {
            int right = 0;
            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }
            rightsum[i] = right;
        }
        for (int i = 0; i < nums.length; i++) {
            leftsum[i] = Math.abs(leftsum[i] - rightsum[i]);
        }
        return leftsum;
    }

    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        int i = 1;
        int j = 0;
        for (; j < res.length; ) {
            // System.out.println(i);
            String substring = word.substring(0, i);
            long num = Long.parseLong(substring);
            //System.out.println("substring    ："+substring);

            if (num % m == 0) {
                res[j] = 1;
                //System.out.println(j);
                word = word.substring(i);
                i = 1;
            } else {
                i++;
            }
            j++;
            //System.out.println("word   ："+word);

        }
        //long num = Long.parseLong(word);
        //if(num % m == 0){
        //    res[res.length - 1] = 1;
        //}
        return res;
    }

    public void meituan2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt(); // 颜色不同时支付的钱币
        String[] colour = new String[m];
        for (int i = 0; i < n; i++) {
            colour[i] = scanner.next();
        }
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (colour[0].charAt(i) != colour[0].charAt(i - 1)) {
                if (dp[0][i - 1] + dp[0][i] < k) {
                    dp[0][i] = -1;
                } else {
                    dp[0][i] = dp[0][i - 1] - k + matrix[0][i];
                }
            } else {
                dp[0][i] = dp[0][i - 1] + matrix[0][i];
            }
        }
        for (int i = 0; i < m; i++) {
            if (colour[i].charAt(0) != colour[i - 1].charAt(0)) {
                if (dp[i][0] + dp[i - 1][0] < k) {
                    dp[i][0] = -1;
                } else {
                    dp[i][0] = dp[i - 1][0] - k + matrix[i][0];
                }
            } else {
                dp[i][0] = dp[i - 1][0] + dp[i][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (colour[i - 1].charAt(j) != colour[i].charAt(j) && colour[i].charAt(j - 1) == colour[i].charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j] - k + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
                }
                if (colour[i - 1].charAt(j) != colour[i].charAt(j) && colour[i].charAt(j - 1) != colour[i].charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j] - k + matrix[i][j], dp[i][j - 1] - k + matrix[i][j]);
                }
                if (colour[i - 1].charAt(j) == colour[i].charAt(j) && colour[i].charAt(j - 1) != colour[i].charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] - k + matrix[i][j]);
                }
                if (colour[i - 1].charAt(j) == colour[i].charAt(j) && colour[i].charAt(j - 1) == colour[i].charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);

    }

    public void mayi1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int j = 0;
            for (; j < n; j++) {
                set.add(arr[j]);
                int div = target - arr[j];
                if (set.contains(div)) {
                    System.out.println("Yes");
                    break;
                }
            }
            if (j == n) {
                System.out.println("No");
            }
        }
    }

    public void duoduo3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        int[][] cost = new int[3][2];
        for (int i = 0; i < 3; i++) {
            cost[i][0] = scanner.nextInt();
            cost[i][1] = scanner.nextInt();
        }

    }

    int N = 40;
    long a[][] = new long[N][N];
    long v[][] = new long[N][N];
    long num[] = new long[N];
    long ans;

    public void xiecheng1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();//最大预算
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            num[i] = m;
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextLong();//价格
            }
            for (int j = 0; j < m; j++) {
                v[i][j] = scanner.nextLong();//性能
            }
        }
        ans = -1;
        dfs(n - 1, x, 0);
        System.out.println(ans);
    }

    void dfs(int n, long cost, long vsum) {
        if (n == -1) {
            ans = Math.max(ans, vsum);
            return;
        }
        for (int i = 0; i < num[n]; i++) {
            if (cost >= a[n][i]) {
                dfs(n - 1, cost - a[n][i], vsum + v[n][i]);
            }
        }
    }

    static int[][] mv = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] vis = new boolean[1010][1010];
    static String[] strings = new String[1010];
    static int n;
    static int m;

    public void mhy1() {
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

    public int dfs1(int x, int y) {
        if (x < 0 || x >= n) return 0;
        if (y < 0 || y >= n) return 0;
        if (vis[x][y]) return 0;
        for (int i = 0; i < 4; i++) {
            if (x + mv[i][0] < 0 || x + mv[i][0] >= n) continue;
            if (y + mv[i][1] < 0 || y + mv[i][1] >= n) continue;
            if (strings[x + mv[i][0]].charAt(y + mv[i][1]) == strings[x].charAt(y)) {
                dfs1(x + mv[i][0], y + mv[i][1]);
            }
        }
        if (!vis[x][y]) vis[x][y] = true;
        return 1;
    }

    public int dfs2(int x, int y) {
        if (x < 0 || x >= n) return 0;
        if (y < 0 || y >= n) return 0;
        if (vis[x][y]) return 0;
        for (int i = 0; i < 4; i++) {
            if (x + mv[i][0] < 0 || x + mv[i][0] >= n) continue;
            if (y + mv[i][1] < 0 || y + mv[i][1] >= n) continue;
            if (strings[x + mv[i][0]].charAt(y + mv[i][1]) == strings[x].charAt(y)
                    || (strings[x + mv[i][0]].charAt(y + mv[i][1]) == 'G' || strings[x + mv[i][0]].charAt(y + mv[i][1]) == 'B')
                    && (strings[x].charAt(y) == 'B' || strings[x].charAt(y) == 'G')
            ) {
                dfs1(x + mv[i][0], y + mv[i][1]);
            }
        }
        if (!vis[x][y]) vis[x][y] = true;
        return 1;
    }
}
