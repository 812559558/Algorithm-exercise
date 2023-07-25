import org.junit.jupiter.api.Test;

public class leko1113 {
    public static void main(String[] args) {
//        double[] doubles = convertTemperature(36.50);
//        System.out.println(doubles[0]);
//        System.out.println(doubles[1]);
        int []a={3,6,2,7,1};
        System.out.println(subarrayLCM(a,6));
        System.out.println(Llc(6,2));
        
    }
    @Test
    public void A(){};

    public static double[] convertTemperature(double celsius){
        double[] res=new double[2];
         res[0]=celsius+273.15;
         res[1]=celsius*1.80+32.00;
        
        return res;
    }
    public static int subarrayLCM(int[] nums, int k) {
        int ans=0;
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            int t=nums[i];
            for (int j = i; j < n; j++) {
                //求nums[j]和t的最小公倍数
                t=Llc(t,nums[j]);
                if(t==k){
                    ans++;

                }
            }
        }

        return ans;
    }
    public static int Llc(int a,int b) {
        int d=a*b;
        int reuslt = 0;
        while(b>0){
            reuslt = a%b;
            a = b;
            b = reuslt;
        }
    return d/a;
    }
}
