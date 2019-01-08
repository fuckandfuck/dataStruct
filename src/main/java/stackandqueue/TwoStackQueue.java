package stackandqueue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 * 1, 入队
 * 2，出队
 * 3，查询将要出队的值
 * Created by Administrator on 2019\1\8 0008.
 */
public class TwoStackQueue {
    public Stack<Integer> stack1 = new Stack<Integer>();
    public Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 入队
     * @param data
     */
    public void offer(Integer data){
        synchronized (stack1){
            stack1.push(data);
        }
    }

    /**
     * 出队
     */
    public Integer pop(){
        if(stack2.empty()){
            syncStack2();
        }
        if(stack2.empty()){
            throw new RuntimeException("队列为空！");
        }
        return stack2.pop();
    }


    /**
     * 查询将要出队的值
     */
    public Integer peek(){
        if(stack2.empty()){
            syncStack2();
        }
        if(stack2.empty()){
            throw new RuntimeException("队列为空！");
        }
        return stack2.peek();
    }

    /**
     * 同步stack1 中的数据到 stack2
     */
    public void syncStack2(){
        synchronized (stack1){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println(queue.peek());
        System.out.println(queue.peek());

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

//        System.out.println(queue.peek());
    }
}
