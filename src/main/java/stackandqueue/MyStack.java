package stackandqueue;

import singlyLinkedList.ListNode;

/**
 * 用链表实现一个栈
 * 1，入栈
 * 2，出栈
 * 3，遍历栈
 * 4，是否为空栈
 * Created by Administrator on 2019\1\8 0008.
 */
public class MyStack {
    public ListNode stackTop; //栈顶
    public ListNode stackBottom; //栈底

    /**
     * 入栈
     */
    public void enStack(ListNode newTop){
        //栈为空
        if(this.isEmpty()){
            stackTop = newTop;
            stackBottom = stackTop;
            return ;
        }
        newTop.setNextNode(stackTop);
        stackTop = newTop;
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.stackBottom == null;
    }

    /**
     * 出栈
     * @return
     */
    public ListNode deStack(){
        if(isEmpty()){
            return null;
        }
        ListNode returnNode = stackTop;
        if(stackTop.getNextNode() == null){
            stackBottom = null;
        }
        stackTop = stackTop.getNextNode();
        return returnNode;
    }

    /**
     * 遍历
     */
    public void traverse(){
        ListNode cur = stackTop;
        while(cur != null ){
            System.out.print(cur.getValue() + "  ");
            cur = cur.getNextNode();
        }
        System.out.println();
    }

    /**
     * 清空栈
     */
    public void clear(){
        stackTop = null;
        stackBottom = stackTop;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.enStack(new ListNode(1));
        stack.enStack(new ListNode(2));
        stack.enStack(new ListNode(3));
        stack.enStack(new ListNode(4));
        stack.enStack(new ListNode(5));

        stack.traverse();

        stack.clear();

        ListNode listNode = stack.deStack();
        System.out.println(listNode.getValue());

        ListNode listNode1 = stack.deStack();
        System.out.println(listNode1.getValue());

        ListNode listNode2 = stack.deStack();
        System.out.println(listNode2.getValue());

        ListNode listNode3 = stack.deStack();
        System.out.println(listNode3.getValue());

        ListNode listNode4 = stack.deStack();
        System.out.println(listNode4.getValue());

//        ListNode listNode5 = stack.deStack();
//        System.out.println(listNode5.getValue());
        stack.traverse();

    }
}
