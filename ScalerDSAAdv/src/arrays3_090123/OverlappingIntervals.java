package arrays3_090123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
// https://www.scaler.com/academy/mentee-dashboard/class/50128/assignment/problems/61?navref=cl_tt_nv
public class OverlappingIntervals {

	public void sortedOverlappingIntervals(int[][] A) { // O(n) O(1)
		int l = A[0][0], r = A[0][1];
		for(int i=0; i<A.length; i++) {
			if(A[i][0]<=r) {
				r = Math.max(r, A[i][1]);
			} else {
				System.out.println(l+" "+r);
				l = A[i][0];
				r = A[i][1];
			}
		}
		System.out.println(l+" "+r);
	}
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) { // for scaler as no arr
		Collections.sort(intervals, (i1, i2)-> i1.start-i2.start);
		ArrayList<Interval> result = new ArrayList<>();
		int l = intervals.get(0).start, r = intervals.get(0).end;
		for(int i=0; i<intervals.size(); i++) {
			if(intervals.get(i).start<=r) {
				r = Math.max(r, intervals.get(i).end);
			} else {
				//System.out.println(l+" "+r);
				Interval inter = new Interval(l, r);
				result.add(inter);
				l = intervals.get(i).start;
				r = intervals.get(i).end;
			}
		}
		Interval inter = new Interval(l, r);
		result.add(inter);
		return result;
    }
	public ArrayList<Interval> mergeScalerSol(ArrayList<Interval> intervals) {
        // Sorting the intervals first based on start point and then based on end point.
        Collections.sort(intervals, new IntervalCompScalerSol());
        
        //res is the ArrayList that we will return
        ArrayList<Interval> res;
        
        Interval inter;
        int n = intervals.size();
        res = new ArrayList<>();
        
        for (int i = 0; i < n;) {
            // making a new segment
            inter = new Interval(intervals.get(i).start, intervals.get(i).end);
            Interval next;
            i++;
            while (i < n) {
                next = intervals.get(i);
                // Checking if i-th element falls in the current segment
                if (overlapScalerSol(inter, next)) {
                    // adding i-th element to the current segment
                    inter.end = Math.max(inter.end, next.end);
                    i++;
                } else {
                    break;
                }
            }
            // adding current segment to our answer.
            res.add(inter);
        }
        return res;
    }
    private boolean overlapScalerSol(Interval int1, Interval int2) {
        if (int1.end >= int2.start && int1.start <= int2.end)
            return true;
        return false;
    }
    
    private class IntervalCompScalerSol implements Comparator<Interval> {
        @Override
        public int compare(Interval interval1, Interval interval2) {
            int cmp =  Integer.compare(interval1.start, interval2.start);
            if (cmp != 0)
                return cmp;
            cmp = Integer.compare(interval1.end, interval2.end);
            return cmp;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverlappingIntervals oli = new OverlappingIntervals();
		int[][] A = {{0,2}, {1,4}, {5,6}, {6,8}, {7, 10}, {8, 9}, {12, 14}};
		oli.sortedOverlappingIntervals(A); // 0 4  5 10  12 14
		Interval in = new Interval(0, 2);
		Interval in1 = new Interval(1, 4);
		Interval in2 = new Interval(5, 6);
		Interval in3 = new Interval(6, 8);
		Interval in4 = new Interval(7, 10);
		Interval in5 = new Interval(8, 9);
		Interval in6 = new Interval(12, 14);
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(in); intervals.add(in1); intervals.add(in2); intervals.add(in3);
		intervals.add(in4); intervals.add(in5); intervals.add(in6);
		ArrayList<Interval> finalIn = oli.merge(intervals);
		for(int i=0; i<finalIn.size(); i++) {
			System.out.println(finalIn.get(i).start + " " +finalIn.get(i).end);
		}
	}

}
/*  failing for this as not sorted
 *  [ (4, 100), (48, 94), (16, 21), (58, 71), (36, 53), (49, 68), (18, 42), (37, 90), (68, 75), (6, 57), (25, 78), (58, 79), (18, 29), (69, 94), (5, 31), (10, 87), (21, 35), (1, 32), (7, 24), (17, 85), (30, 95), (5, 63), (1, 17), (67, 100), (53, 55), (30, 63), (7, 76), (33, 51), (62, 68), (78, 83), (12, 24), (31, 73), (64, 74), (33, 40), (51, 63), (17, 31), (14, 29), (9, 15), (39, 70), (13, 67), (27, 100), (10, 71), (18, 47), (48, 79), (70, 73), (44, 59), (68, 78), (24, 67), (32, 70), (29, 94), (45, 90), (10, 76), (12, 28), (31, 78), (9, 44), (29, 83), (21, 35), (46, 93), (66, 83), (21, 72), (29, 37), (6, 11), (56, 87), (10, 26), (11, 12), (15, 88), (3, 13), (56, 70), (40, 73), (25, 62), (63, 73), (47, 74), (8, 36) ]
 */
class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
}