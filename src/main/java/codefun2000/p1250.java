package codefun2000;

import java.util.Scanner;

public class p1250 {
    static int t = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String s = sc.next();
        String[] split = s.split("\\+");
        int p1 = split[0].indexOf('.');
        int p2 = split[1].indexOf('.');
        String left_a = split[0], left_b = split[1], right_a = "", right_b = "";
        if (p1 != -1) {
            left_a = split[0].substring(0, p1);
            right_a = split[0].substring(p1 + 1);
        }
        if (p2 != -1) {
            left_b = split[1].substring(0, p2);
            right_b = split[1].substring(p2 + 1);
        }
        String right = get_val(right_a, right_b, false);

        String left = get_val(left_a, left_b, true);
        String res = left;
        if (right.length() > 0) res += "." + right;
        System.out.println(res);
    }

    public static String get_val(String a, String b, boolean op) {
        if (a.length() > b.length()) {
            String c = a;
            a = b;
            b = c;
        }
        //System.out.println(a+"   "+b);
        StringBuilder builder_a = new StringBuilder(a);
        StringBuilder builder_b = new StringBuilder(b);
        builder_b.reverse();
        if (op) {//小数点左边
            builder_a.reverse();
            while (builder_a.length() < b.length()) builder_a.append('0');
        } else {//小数点右边
            while (builder_a.length() < b.length()) builder_a.append('0');
            builder_a.reverse();
        }
        //System.out.println(builder_a+"   "+builder_b);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < builder_a.length(); i++) {
            char num1 = builder_a.charAt(i), num2 = builder_b.charAt(i);
            if (num1 >= '0' && num1 <= '9' && num2 >= '0' && num2 <= '9') t += (num2 - '0') + (num1 - '0');
            else if (num1 == '!' && num2 == '!') {

            } else if (num1 == '!' && num2 == '@' || num2 == '!' && num1 == '@') {
                t += 13;
            } else if (num1 == '!' && num2 == '#' || num2 == '!' && num1 == '#') {
                t += 4;
            } else if (num1 == '@' && num2 == '#' || num2 == '@' && num1 == '#') {
                t += 20;
            } else if (num1 == '@' && num2 == '@') {
                t += 7;
            } else if (num1 == '#' && num2 == '#') {
                t += 5;
            }
            res.append(t % 10);
            t /= 10;
        }
        if (op) {
            if (t != 0) res.append(t);
            while (res.length() > 1 && res.charAt(res.length() - 1) == '0') res.deleteCharAt(res.length() - 1);
        }
        res.reverse();
        if (!op) {
            while (res.length() > 0 && res.charAt(res.length() - 1) == '0') res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}
