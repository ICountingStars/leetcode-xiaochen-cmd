package easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * 从头到尾打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * eg:
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * limit:
 * 0 <= 链表长度 <= 10000
 *
 * @author chenjianglin
 * @date 2021/2/21
 * @since 1.0.0
 **/
public class PrintLinkFromEndToTop {

    //用栈的特性来解题  测
    public static int[] printLinkFromEndToTop2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = stack.pop().val;
        }
        return ints;
    }

    //自己写的暴力写法
    public static int[] printLinkFromEndToTop(int[] head) {
        int length = head.length;
        int[] ints = new int[length];
        int size = 0;
        for (int i = length-1; i >= 0; i--) {
            ints[size] = head[i];
            size++;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] head = {1,3,2};
        System.out.println(Arrays.toString(printLinkFromEndToTop(head)));

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(Arrays.toString(printLinkFromEndToTop2(listNode)));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
