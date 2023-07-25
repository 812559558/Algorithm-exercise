import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {
    public static void main(String[] args) {

    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String t = words.get(i);
            String regex = "\\" + separator;
            String[] split = t.split(String.valueOf(regex));
            for (String s : split) {
                // System.out.println(s);
                if (!s.isEmpty()) {
                    res.add(s);
                }
            }
        }
        return res;
    }

    public long maxArrayValue(int[] nums) {

        int l = nums.length;
        int[] valid = new int[nums.length];
        long[] res = new long[nums.length];
        for (int i = 0; i < l; i++) {
            res[i] = nums[i];
        }
        int del = 0;

        int i = 0;
        while (i < l - 1 && l - del >= 2) {
            if (valid[i] != 1) {
                int nex = i + 1;
                while (nex < l && valid[nex] == 1) {
                    nex++;
                }
                if (nex < l && valid[nex] != 1) {
                    if(res[i]<=res[nex]){
                        res[nex] = res[i] + res[nex];
                        valid[i] = 1;
                        del++;
                    }

                }
            }
            i++;
        }
        Arrays.sort(res);
        return res[res.length - 1];
    }
}
