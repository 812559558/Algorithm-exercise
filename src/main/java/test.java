import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt(),x= scanner.nextInt();
        int[] url=new int[x];
        int max=0;
        for (int i = 0; i < x; i++) {
            url[i]= scanner.nextInt();
        }
        int y= scanner.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<y;i++){
            map.put(scanner.nextInt(),scanner.nextInt());
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1, o2) -> o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]);
        Map<Integer,int[]> cache=new HashMap<>();
        int[] ans=new int[x];
        for(int i=0;i<x;i++){
            //先删除持续时间结束的
            while(pq.size()>0&&pq.peek()[1]<=i){
                int[] rem=pq.poll();
                cache.remove(rem[2]);
            }
            if(cache.containsKey(url[i])){
                ans[i]=0;
            }else {
                ans[i]=1;
                //如果优先队列的第一个元素的结束时间小于当前时间
                if(pq.size()==n){
                    int[] rem=pq.poll();
                    cache.remove(rem[2]);
                }
                //开始时间 结束时间 url
                int[] add=new int[]{i,i+map.getOrDefault(url[i],5),url[i]};
                pq.offer(add);
                cache.put(url[i],add);
            }
        }
        for(int i=0;i<x;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
