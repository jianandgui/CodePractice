package sort;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(5);

        Thread s1 = new Thread(new consumer(arrayBlockingQueue));
        Thread s2 = new Thread(new consumer(arrayBlockingQueue));
        Thread s3 = new Thread(new consumer(arrayBlockingQueue));
        Thread p1 = new Thread(new producer(arrayBlockingQueue));
        Thread p2 = new Thread(new producer(arrayBlockingQueue));
        s1.setName("消费者1");
        s2.setName("消费者2");
        s3.setName("消费者3");
        p1.setName("生产者1");
        p2.setName("生产者2");

        s1.start();
        s2.start();
        s3.start();
        p1.start();
        p2.start();

    }


}

class consumer implements Runnable {

    private ArrayBlockingQueue<Integer> arrayBlockingQueue;

    public consumer(ArrayBlockingQueue arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            arrayBlockingQueue.poll();
            System.out.println("我是线程: "+Thread.currentThread().getName()+"现在队列里面还有"+arrayBlockingQueue.size());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class producer implements Runnable {

    private ArrayBlockingQueue<Integer> arrayBlockingQueue;

    public producer(ArrayBlockingQueue arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            arrayBlockingQueue.offer(1);
            System.out.println("我是线程: "+Thread.currentThread().getName()+"现在队列里面还有"+arrayBlockingQueue.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

