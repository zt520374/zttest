package com.sitech.threadtest;

public class ThreadTestDemo1 {

    public static void main(String[] args) {
        ThreadTest1 tr1 = new ThreadTest1("A");
        ThreadTest1 tr3 = new ThreadTest1("C");
        ThreadTest2 threadTest2 = new ThreadTest2("B");
        Thread tr2 = new Thread(threadTest2);
        //优先级，只是增大线程执行的
        tr1.setPriority(Thread.MAX_PRIORITY);
        tr2.setPriority(Thread.MIN_PRIORITY);
        tr3.setPriority(Thread.NORM_PRIORITY);
        tr1.start();
        tr2.start();
        tr3.start();
    }

}

class ThreadTest1 extends Thread{

    private  String name;

    public  ThreadTest1(String name){
        this.name = name;
    }

    //重写run()方法
    @Override
    public void run() {
       for(int i = 0; i < 1000; i++){
//        System.out.println(name + ":" + i);
           System.out.println(Thread.currentThread() + "======" + Thread.currentThread().getName());

       }
    }
}



    class  ThreadTest2 implements Runnable{

    private  String name;

    public  ThreadTest2(String name){
        this.name = name;
    }

    public void run() {
        for(int i = 0; i < 1000; i++){
//            System.out.println(name + ":" + i);
            System.out.println(Thread.currentThread() + "======" + Thread.currentThread().getName());
        }
    }
}
