package difficult;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: godder
 * @date: 2019/3/15
 */
/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2
 */
public class MedianFinder {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue();
        min = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (min.size() == 0) {
            min.add(num);
            return;
        }
        if (num > min.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }
        for (int i = max.size() - min.size(); i > 1; i--) {
            min.add(max.remove());
        }
        for (int i = min.size() - max.size(); i > 1; i--) {
            max.add(min.remove());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (this.min.peek() + this.max.peek()) / 2.0;
        }
        if (min.size() > max.size()) {
            return min.peek();
        } else {
            return max.peek();
        }
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
