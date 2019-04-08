package singlyLinkedList;

/**
 * 单链表的一些常用算法总结
 * 1.遍历
 * 2.取中间值
 * 3.合并两个链表
 * 4.反转链表
 * 5.对链表进行归并排序
 * 6.对奇数位升序，偶数位降序的单链表进行排序
 * Created by zhaoweihua on 2019\1\7 0007.
 */
public class ArithmeticOfSinglyList {

    /**
     * 对奇数位升序，偶数位降序的单链表进行排序
     * 思路：
     * 1，拆分为两个链表
     * 2，对奇数位链表反转
     * 3，合并两个链表
     * @return
     */
    public static ListNode interview(ListNode head){
        ListNode[] nodes = getNodes(head);
        ListNode jishuNode = nodes[0];
        ListNode oushuNode = nodes[1];
        ListNode reverseNode = reverse(jishuNode);
        ListNode mergeNode = merge(oushuNode, reverseNode);
        return mergeNode;
    }

    /**
     * 对链表进行奇数位和偶数位的拆分
     * @param head
     * @return
     */
    private static ListNode[] getNodes(ListNode head){
        ListNode [] nodes = new ListNode[2];
        ListNode node1 = null;
        ListNode node2 = null;

        ListNode cur1 = node1; //指向node1的末尾元素
        ListNode cur2 = node2;  //指向node2 的末尾元素

        int i = 1;

        while(head != null){
            if(i % 2 != 0){//奇数位

                if(node1 != null){
                    cur1.setNextNode(head);
                    cur1 = head;

                }else{
                    node1 = head;
                    cur1 = head;
                }
            }else{
                if(node2 != null){
                    cur2.setNextNode(head);
                    cur2 = head;
                }else{
                    node2 = head;
                    cur2 = head;
                }
            }
            i++;
            head = head.getNextNode();
        }
        cur1.setNextNode(null);//末尾元素的下一个置为null
        cur2.setNextNode(null);
        nodes[0] = node1;
        nodes[1] = node2;
        return nodes;
    }

    /**
     * 对链表进行归并排序思路：
     * 1，取中间值切分
     * 2，对切分的子串进行合并
     * @param head
     * @return
     */
    public static ListNode guiBingSort(ListNode head){
        if(head == null || head.getNextNode() == null){
            return head;
        }
        ListNode middleNode = getMiddleNode(head);
        ListNode head2 = middleNode.getNextNode();
        middleNode.setNextNode(null);
        ListNode head1 = head;

        return merge(guiBingSort(head1), guiBingSort(head2));
    }


    /**
     * 对链表进行反转
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode next = null; //反转列表的尾节点
        ListNode cur = head.getNextNode(); //指针指向head的下一个元素
        ListNode reverseHead = head; //反转列表的头结点
        while(cur != null){
            next = reverseHead;
            reverseHead = cur;
            cur = cur.getNextNode();
            reverseHead.setNextNode(next);
            if(next.getNextNode() == reverseHead){
                next.setNextNode(null);
            }
        }
        return reverseHead;
    }

    /**
     * 两个有序链表进行合并
     */
    public static ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
        ListNode mergeNode ;
        if(Integer.parseInt(head1.getValue().toString()) <= Integer.parseInt(head2.getValue().toString())){
            mergeNode = head1;
            mergeNode.setNextNode(merge(head1.getNextNode(), head2));
        }else{
            mergeNode = head2;
            mergeNode.setNextNode(merge(head1,head2.getNextNode()));
        }
        return mergeNode;
    }

    /**
     * 获取中间节点的值（获取中间节点）
     */
    public static ListNode getMiddleNode(ListNode head){
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.getNextNode() != null &&fast.getNextNode().getNextNode() != null){
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }
        System.out.println(slow.getValue().toString());
        return slow;
    }

    /**
     * 遍历
     */
    public static void iterate(ListNode head){
        if(head == null){
            return ;
        }
        while(head.getNextNode() != null){
            System.out.print(head.getValue().toString() + "  ");
            head = head.getNextNode();
        }
        System.out.println(head.getValue().toString());
    }

    /**
     * 简单生成一个单链表
     */
    private static ListNode generate(int var1,int var2, int var3, int var4, int var5){
        ListNode node1 = new ListNode(var1);
        ListNode node2 = new ListNode(var2);
        ListNode node3 = new ListNode(var3);
        ListNode node4 = new ListNode(var4);
        ListNode node5 = new ListNode(var5);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        return node1;
    }

    /**
     * 简单生成一个单链表
     */
    private static ListNode generate(){
        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(7);
        node1.setNextNode(node2);
        node2.setNextNode(node3);
        node3.setNextNode(node4);
        node4.setNextNode(node5);
        node5.setNextNode(node6);
        node6.setNextNode(node7);
        node7.setNextNode(node8);
        return node1;
    }

    public static void main(String[] args) {

        ListNode head1 = generate(1, 3, 5, 7, 9);
        ListNode head2 = generate(2, 4, 6, 8, 10);

        System.out.println("----遍历head1----");
        iterate(head1);
        System.out.println("----取head1中间值----");
        getMiddleNode(head2);
        System.out.println("----遍历合并后的值----");
        iterate(merge(head1,head2));
        System.out.println("----遍历head1----");
        iterate(head1);
        System.out.println("----遍历head2----");
        iterate(head2);
        System.out.println("----反转head1----");
        iterate(reverse(head1));
        System.out.println("-----面试一------");
        iterate(interview(generate()));
        System.out.println("----归并算法测试-----");
        ListNode head = generate(5, 7, 6, 4, 1);
        iterate(guiBingSort(head));
        //tag test
    }
}
