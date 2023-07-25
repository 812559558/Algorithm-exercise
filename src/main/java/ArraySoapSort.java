public class ArraySoapSort {
    public static void main(String[] args) {
        Mytools mt=new Mytools();
        int[] arr={10,-1,8,0};
        mt.bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
        double d=13.4;
   }
}
class Mytools{
    public void bubble(int[]arr){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
class  Person{
    String name;

}
