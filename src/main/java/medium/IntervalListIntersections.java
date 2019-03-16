package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: godder
 * @date: 2019/3/17
 */

/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)


 */

//Time: 9ms
public class IntervalListIntersections {
    public class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0, j = 0; i < A.length && j < B.length;) {
            Interval a = A[i], b = B[j];
            if (a.end < b.start) {
                i++;
                continue;
            }
            if (a.start > b.end) {
                j++;
                continue;
            }
            Interval section = new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
            list.add(section);
            if (a.end < b.end) {
                i++;
                continue;
            }
            if (a.end == b.end) {
                i++; j++;
                continue;
            }
            if (a.end > b.end) {
                j++;
            }
        }
        Interval[] result = new Interval[list.size()];
        list.toArray(result);
        return result;
    }
}
