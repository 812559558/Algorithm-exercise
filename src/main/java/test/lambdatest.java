package test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class lambdatest {
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津");
        List<String> s = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
    }

    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : filterList) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

    public void test() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        //方法引用，本质上就是lambda表达式,lambda作为函数式接口的s实例
        //对象：实例方法
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");
        Function<Double, Long> func1 = d -> Math.round(d);
        Stream<String> stream;
    }

    public void xiecheng01() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) <= 1) {
                dp[i] = dp[i - 1] + 1;
            }
            count = count > dp[i] ? count : dp[i];
        }

        System.out.println(count);
    }

    public void xiecheng02() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String str = in.next();
        StringBuilder builder = new StringBuilder(str);
        char[] chars = str.toCharArray();
        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int len = str.length();
            for (int j = l - 1; j < l + (r - l) * 2; j = j + 2) {
                builder.insert(j, builder.charAt(j));
            }
        }
        System.out.println(builder);
    }
    static int v0,x,y;
    static float res = Float.MIN_VALUE;
    public void xiecheng03() {
        Scanner in = new Scanner(System.in);
         v0 = in.nextInt();
         x = in.nextInt();
         y = in.nextInt();


        System.out.printf("%.5f",res);
    }
    static float calc(float t){
        float t2 =v0+t*x;
        res = Math.min(res,t2);
        return t+t2;
    }
    public void xiecheng04() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();


    }
}