package stackandqueue;

/**
 * 用数组实现一个有界队列
 * 1, 入队
 * 2，出队
 * 3，遍历
 * 4，是否为满
 * 5，是否为空
 * Created by Administrator on 2019\1\8 0008.
 */
public class MyQueue {
    public Object[] arry ;
    public int first;
    public int last;
    public MyQueue(int size){
        arry = new Object[size];
    }

    /**
     * 是否为满
     */
    public boolean isFull(){
        return  (last+1) % arry.length == first;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return first == last;
    }

    /**
     * 入队列
     * @param o
     */
    public void enQueue(Object o){
        if(!isFull()){
            arry[last] = o;
            last = (last +1) % arry.length;
        }else{
            throw new RuntimeException("队列已满！");
        }
    }

    /**
     * 出队列
     * @return
     */
    public Object deQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        Object returnValue = arry[first];
        first = (first +1) % arry.length;
        return returnValue;
    }

    /**
     * 遍历
     */
    public void traverse(){
        int cur = first;
        while(cur != last){
            System.out.print(arry[cur].toString() + " ");
            cur = (cur +1) % arry.length ;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
//        queue.enQueue(5);

        queue.traverse();

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        queue.enQueue(5);
        queue.enQueue(6);
        queue.traverse();

        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
//        queue.deQueue();
        System.out.println(queue.isEmpty());
    }

}
