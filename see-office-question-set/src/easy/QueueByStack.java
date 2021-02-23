package easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * eg：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * limit:
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * @author chenjianglin
 * @date 2021/2/23
 * @since 1.0.0
 **/
public class QueueByStack {
    public static void main(String[] args) {

    }

    /**
     * stack1为添加栈  stack2为删除栈
     * 添加时stack1末尾添加
     * 删除时：有以下三种情况
     * 1.stack2中有元素，那直接弹出元素
     * 2.stack2无元素，
     * 2.1 stack1中没有元素，直接返回-1
     * 2.2 stack1中有元素，要删除的stack1中的元素，需要将次元素之后的押入的元素都弹出，再弹出次元素
     * stack1弹出的元素都压入stack2中,stack再弹出次元素(栈尾元素就是次元素)
     */
    public static class CQueue3 {
        private LinkedList<Integer> stack1, stack2;

        public CQueue3() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead(int value) {
            if (!stack2.isEmpty()) {
                return stack2.removeLast();
            }
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast());
            }
            return stack2.removeLast();
        }
    }

    public static class CQueue2 {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue2() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead(int value) {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.isEmpty() ? -1 : stack2.pop();
            }
        }
    }


    public static class CQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            this.stack1 = new LinkedList<>();
            this.stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead(int value) {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                return stack2.pop();//删除的元素
            }
        }
    }
}
