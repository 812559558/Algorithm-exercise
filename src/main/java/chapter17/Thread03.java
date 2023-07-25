package chapter17;

public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread = new Thread(t1);
        thread.start();
        Thread thread2 = new Thread(t2);
        thread2.start();
        System.out.println("main");
    }
}
class T1 implements Runnable{
    int count=0;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello World"+(++count));
            if(count==10){
                break;
            }
        }

    }
}
class T2 implements Runnable{
    int count=0;
    @Override
    public void run() {
        while (true){
            try {
        Thread.sleep(1000);
        } catch (InterruptedException e) {
        throw new RuntimeException(e);
        }
        System.out.println("hi"+(++count));

            if(count==5){
                break;
            }
        }

    }
}