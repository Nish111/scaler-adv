package arrays3_090123;

import java.util.ArrayList;
import java.util.HashMap;

public class NonOverlappingIntervalInsert { // not getting correct

	public HashMap<Integer, Integer> insertInterval(int[][] A, int[] I) {
		HashMap<Integer, Integer> ans = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(I[0] > A[i][1]) {
				ans.put(A[i][0], A[i][1]);
			} else if(A[i][0]>I[1]) {
				ans.put(I[0], I[1]);
				for(int j=1; j<A.length; j++) {
					ans.put(A[j][0], A[j][1]);
				}
				return ans;
			}
			I[0] = Math.min(I[0], A[i][0]);
			I[1] = Math.max(I[1], A[i][1]);
		}
		ans.put(I[0], I[1]);
		return ans;
	}
	public void insertIntervalPrint(int[][] A, int[] I) { 
		// else was missing for I[0], I[1]
		HashMap<Integer, Integer> ans = new HashMap<>();
		for(int i=0; i<A.length; i++) {
			if(I[0] > A[i][1]) {
				System.out.println(A[i][0] +" "+ A[i][1] +" "+i);
			} else if(A[i][0]>I[1]) {
				System.out.println(I[0] +" "+ I[1] +" "+i);
				for(int j=i; j<A.length; j++) {
					System.out.println(A[j][0] +" "+ A[j][1] +" "+i+" "+j);
				}
				return ;
			} else {
				I[0] = Math.min(I[0], A[i][0]);
				I[1] = Math.max(I[1], A[i][1]);
			}
			
		}
		//System.out.println(I[0] +" "+ I[1]);
	}
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
		//int start = Math.min(newInterval.start, newInterval.end);
		//int end = Math.max(newInterval.end, newInterval.start);
		//newInterval.start = start;
	    //newInterval.end = end;
	    ArrayList<Interval> ans = new ArrayList<Interval>();
	    for(int i =0;i<intervals.size();i++){
	        if(intervals.get(i).end < newInterval.start){
	           ans.add(intervals.get(i));
	        }else if(intervals.get(i).start>newInterval.end){
	           ans.add(newInterval);
	           for(int j = i;j<intervals.size();j++){
	              ans.add(intervals.get(j));
	           }
	           return ans;
	        }else{
	             newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
	             newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
	        }
	    }
	    ans.add(newInterval);
	    return ans;
		
	}
	public ArrayList<Interval> insertScalerSol(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;
        int startIndex = -1;
        int endIndex = -1;
        for (Interval in : intervals) {
            if (start >= in.start && start <= in.end)
                startIndex = i;
            if (end >= in.start && end <= in.end)
                endIndex = i;
            i++;
        }
        // endpoints of new interval doesn't lie inside any other interval
        if (startIndex == -1 && endIndex == -1) {
            startIndex = 0;
            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }
            endIndex = intervals.size() - 1;
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }
            // Intervals between startIndex and endIndex lies completely inside new interval
            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }
            intervals.add(startIndex, newInterval);
            return intervals;
        }
        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }
        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }
        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);
        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;
        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }
        return intervals;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonOverlappingIntervalInsert noii = new NonOverlappingIntervalInsert();
		int[][] A = {{1, 3}, {4, 7}, {10, 14}, {16, 19}, {21, 24}, {27, 30}, {32, 35}, {38, 41}};
		int[] I = {10, 22};
		int[][] B = {{1, 3}, {4, 7}, {10, 14}, {16, 19}, {21, 24}, {27, 30}, {32, 35}, {38, 41}};
		int[] J =  {25, 26};
		//noii.insertInterval(A, I);
		noii.insertIntervalPrint(A, I);
		noii.insertIntervalPrint(B, J);
		int[][] C = {{1,3}, {6,9}};
		int[] X = {2,5};
		int[][] D = {{1,3}, {6,9}};
		int[] Y = {2,6};
		noii.insertIntervalPrint(C, X);
		noii.insertIntervalPrint(D, Y);
		Interval in = new Interval(1, 3);
		Interval in1 = new Interval(4, 7);
		Interval in2 = new Interval(10, 14);
		Interval in3 = new Interval(16, 19);
		Interval in4 = new Interval(21, 24);
		Interval in5 = new Interval(27, 30);
		Interval in6 = new Interval(32, 35);
		Interval in7 = new Interval(10, 22);
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(in); intervals.add(in1); intervals.add(in2); intervals.add(in3);
		intervals.add(in4); intervals.add(in5); intervals.add(in6);
		ArrayList<Interval> finalIn = noii.insert(intervals, in7);
		for(int i=0; i<finalIn.size(); i++) {
			System.out.println(finalIn.get(i).start + " " +finalIn.get(i).end);
		}
		
	}

}

