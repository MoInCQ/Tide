package aprivate.mo.tide.ui.explore.classify;

import java.util.List;

/**
 * Created by Mo on 2020/3/27
 */

public class DeleteListNode {

    class ListNode {
        int value;
        ListNode next;
    }

    public void delete(ListNode node) {

        //拿到下一个和下下个
        ListNode nextNode = node.next;
        ListNode nextNextNode = nextNode.next;

        //下一个的值覆盖当前的
        node.value = nextNode.value;

        //对下一个Node进行摘链
        node.next = nextNextNode;
        nextNode.next = null;


    }
}
