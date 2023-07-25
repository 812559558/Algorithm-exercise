package chapter17;

public class HomeWork02 {
    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t);
        thread.setName("t1");
        Thread thread1 = new Thread(t);
        thread1.setName("t2");
        thread.start();
        thread1.start();
    }
}
//多个线程共享资源，所以用Runnable
//每次取1000
class T implements Runnable{
private int money=10000;
    @Override
    public void run() {
        while (true){
            synchronized (this){


                if(money<1000){
                    System.out.println("余额不足");
                    break;
                }
                money-=1000;
                System.out.println(Thread.currentThread().getName()+"取出了1000，当前余额"+money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}