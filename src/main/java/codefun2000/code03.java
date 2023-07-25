package codefun2000;

import java.util.Scanner;

public class code03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int cnt = isvalid(chars);

        if (cnt == 0) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 'a') {
                    chars[i] = 'a';
                    chars[chars.length - 1 - i] = 'a';
                    break;
                }
            }
        } else {
            if (cnt == 1) {
                if (chars.length % 2 == 0) {
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] != chars[chars.length - 1 - i]) {
                            chars[i] = 'a';
                            chars[chars.length - 1 - i] = 'a';
                            break;
                        }
                    }
                } else {

                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] != chars[chars.length - 1 - i]) {
                            if (chars[i] == 'a' || chars[chars.length - 1 - i] == 'a') {
                                chars[chars.length - 1 - i] = 'a';
                                chars[i] = 'a';
                                chars[chars.length / 2] = 'a';
                            } else {
                                chars[i] = 'a';
                                chars[chars.length - 1 - i] = 'a';
                            }
                            break;
                        }
                    }
                }
            } else {
                for (int i = 0; i < chars.length / 2; i++) {
                    if (chars[i] != chars[chars.length - 1 - i]) {
                        if (chars[i] < chars[chars.length - 1 - i]) {
                            chars[chars.length - 1 - i] = chars[i];
                        } else {
                            chars[i] = chars[chars.length - 1 - i];
                        }
                    }
                }
            }
        }
        System.out.println(String.valueOf(chars));
    }

    public static int isvalid(char[] chars) {
        int cnt = 0;
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {

            } else {
                cnt++;
            }
            left++;
            right--;
        }
        return cnt;
    }
}
