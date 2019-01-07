package singlyLinkedList;

/**
 * 单链表
 * Created by zhaoweihua on 2019\1\7 0007.
 */
public class ListNode {

    private Object value ;

    private ListNode nextNode;

    public ListNode(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}
