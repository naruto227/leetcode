package queue;

/**
 * 面试题59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

 若队列为空，pop_front 和 max_value 需要返回 -1

 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 暴力解法
 * Created by Michael Allan on 2020/3/8.
 */
public class MaxQueue {
    int[] elements = new int[10000];
    int head = 0;
    int tail = 0;

    public MaxQueue() {

    }

    public int max_value() {
        int max = -1;
        for (int i = head; i < tail; i++) {
            max = Math.max(elements[i], max);
        }
        return max;
    }

    public void push_back(int value) {
        elements[tail++] = value;
    }

    public int pop_front() {
        if (head == tail)
            return -1;
        return elements[head++];
    }
}
/**
 * 双端队列法
 */
//class MyQueue {
//    int head = 0;
//    int tail = 0;
//    int[] elements = new int[10000];
//    int[] deque = new int[10000];
//    int first = 0;
//    int second = 0;
//    public MaxQueue() {
//
//    }
//
//    public int max_value() {
//        if (first == second) {
//            return -1;
//        }
//        return deque[first];
//    }
//
//    public void push_back(int value) {
//        elements[tail++] = value;
//        while (first != second) {
//            if(value > deque[second - 1]) {
//                second--;
//            }else {
//                break;
//            }
//        }
//        deque[second++] = value;
//    }
//
//    public int pop_front() {
//        if (head == tail)
//            return -1;
//        int popValue = elements[head];
//        if(popValue == deque[first]) {
//            first++;
//        }
//        head++;
//        return popValue;
//    }
//}
