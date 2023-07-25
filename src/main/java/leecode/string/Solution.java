package leecode.string;

import java.util.ArrayDeque;

public class Solution {
    public void reverseString(char[] s) {
        int len=s.length;
        int j=len-1;
        char tem;
        for (int i = 0; i < len/2; i++) {
            tem=s[i];
            s[i]=s[j];
            s[j]=tem;
            j--;
        }
    }
    public String reverseStr(String s, int k) {
        int n=s.length();
        char []arr=s.toCharArray();
        for (int i = 0; i < n; i+=2*k) {
            reverse(arr,i,Math.min(i+k,n)-1);
        }
        return new String(arr);
    }
    public void reverse(char[] arr,int left,int right){
        while (left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public String replaceSpace(String s) {
        char []arr=s.toCharArray();
        char[] arr2 = new char[arr.length*3];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==' '){
                arr2[j++]='%';
                arr2[j++]='2';
                arr2[j++]='0';
            }else {
                arr2[j++]=arr[i];
            }
        }
        return new String(arr2,0,j);
    }
    public String reverseWords(String s) {
        StringBuilder sb=trimSpaces(s);
        reverse(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return  sb.toString();
    }
    public  StringBuilder trimSpaces(String s){
        int left=0,right=s.length()-1;
        while (left<=right&&s.charAt(left)==' '){
            ++left;
        }
        while (left<=right&& s.charAt(right)==' '){
            --right;
        }
        StringBuilder sb=new StringBuilder();
        while (left<=right){
            char c=s.charAt(left);
            if(c!=' '){
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1)!=' '){
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }
    public void reverse(StringBuilder sb, int left, int right){
        while (left<right){
            char tem= sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,tem);
        }
    }
    public void reverseEachWord(StringBuilder sb){
        int n=sb.length();
        int start=0,end=0;
        while (start<n){
            while (end<n&&sb.charAt(end)!=' '){
                ++end;
            }
            reverse(sb,start,end-1);
            start=end+1;
            ++end;
        }
    }
    public String reverseWords2(String s){
        int left=0,right=s.length()-1;
        while (left<=right && s.charAt(left)==' '){
            left++;
        }
        while (left<=right && s.charAt(right)==' '){
            right--;
        }
        ArrayDeque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left<=right){
            char c=s.charAt(left);
            if((word.length()!=0)&&(c==' ')){
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());
        return String.join(" ",d);
    }
    public String reverseLeftWords(String s, int n) {
        //abcdefg gfedcba
        //cdefgab
        String a=reverseWords(s,0,s.length());
        String b=reverseWords(a,0,s.length()-n);
        String c=reverseWords(b,s.length()-n,s.length());
        return c;
    }
    public String reverseWords(String s, int start,int end) {
        //abcdefg gfedcba
        //cdefgab
        int len=end-start;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len/2; i++) {
            char tem=chars[start+i];
            chars[start+i]=chars[end-1-i];
            chars[end-1-i]=tem;
        }

        return new String(chars);
    }
    public int strStr(String haystack, String needle) {
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int j=0;
        for (int i = 0; i < a.length; i++) {
            int k=i;
            if(b.length>a.length-i-1){
                break;
            }
            for (; j < b.length; j++) {
                if(a[k]!=b[j]){
                    break;
                }
                k++;
            }
            if(j== b.length){
                return i;
            }
            j=0;
        }
        return -1;
    }
}
