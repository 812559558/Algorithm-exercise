package chapter17;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}
class A extends Thread{
    private boolean loop=true;

    public void setLoop(boolean loop) {//可以修改loop
        this.loop = loop;
    }

    public void run(){
        while (loop){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B extends Thread{
    private A a;
    private Scanner scanner=new Scanner(System.in);
    public B(A a){
        this.a=a;
    }

    @Override
    public void run() {
        //接收到用户输入
        while (true){
            System.out.println("请输入你的指令,Q退出");
            char key=scanner.next().toUpperCase().charAt(0);
            if(key=='Q'){
                //以通知的方式结束A线程
                a.setLoop(false);
                System.out.println("b线程退出");
                break;
            }
        }

    }
}