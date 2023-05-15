package heaps2_030423;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
// https://www.scaler.com/academy/mentee-dashboard/class/70939/homework/problems/446/submissions
public class SpecialMedian { // check once
	public int solveMine(int[] A) {
		PriorityQueue<Integer> pqMin = new PriorityQueue<>();
		PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)->b-a);
		for(int i = 0; i < A.length - 1; i++) {
	        double median = -1;
	        if(pqMin.size() == pqMax.size()) {
	        	pqMax.add(A[i]);
	            pqMin.add(pqMax.poll());
	            median = (double)pqMin.peek();
	        } else {
	        	pqMin.add(A[i]);
	            pqMax.add(pqMin.poll());
	            median = (pqMin.peek() + pqMax.peek())/2.0;
	        }
	        if(median == A[i + 1]){
	            return 1;
	        }
	    }

	    pqMin.clear();
	    pqMax.clear();

	    for(int i = A.length - 1; i > 0; i--) {
	        double median = -1;
	        if(pqMin.size() == pqMax.size()) {
	        	pqMax.add(A[i]);
	            pqMin.add(pqMax.poll());
	            median = (double)pqMin.peek();
	        } else {
	        	pqMin.add(A[i]);
	        	pqMax.add(pqMin.poll());
	            median = (pqMin.peek() + pqMax.peek())/2.0;
	        }
	        if(median == A[i - 1]){
	            return 1;
	        }
	    }

	    return 0;
	}
	public int solve(int[] A) {
		PriorityQueue<Integer> pqMin = new PriorityQueue<>();
		PriorityQueue<Integer> pqMax = new PriorityQueue<>((a,b)->b-a);
		int n=A.length, k=0;
		if(n==1) return 0;
		double median=0, sum=0;
		while(k<n-1) {
			pqMin.add(A[k]);
			sum +=A[k];
			median = sum/(k+1);
			k++;
			if(A[k]==median) return 1;
		}
		k=n-1;
		sum=0; median=0;
		while(k>0) {
			pqMax.add(A[k]);
			sum +=A[k];
			median = sum/(n-k);
			k--;
			if(A[k]==median) return 1;
		}
		return 0;
    }
	public int solve1(int[] A) {

        int n = A.length;

        if( n == 1 ){
            return 0;
        }
        double left[] = new double[n];

        double right[] = new double[n];

        PriorityQueue<Integer> leftMaxPq = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> leftMinPq = new PriorityQueue<>();

        left[0] = A[0];
       
        left[1] = ( ((double)A[0] + A[1]) / 2);

        leftMaxPq.offer(Math.min( A[0] , A[1] ));

        leftMinPq.offer(Math.max( A[0] , A[1] ));

        int index = 2;

        for(int i=2; i<n ; i++){

               if(A[i] <= leftMaxPq.peek()){
                leftMaxPq.offer(A[i]);

                if( leftMaxPq.size() - leftMinPq.size() > 1){
                    leftMinPq.offer(leftMaxPq.poll());
                }
            }
            else{
                leftMinPq.offer(A[i]);

                if(leftMinPq.size() - leftMaxPq.size() > 1){
                    leftMaxPq.offer(leftMinPq.poll());
                }
            }

            if(leftMaxPq.size() == leftMinPq.size()){
                left[index] = ((double)leftMaxPq.peek() + leftMinPq.peek())/2;
            }
            else if( leftMaxPq.size() > leftMinPq.size() ){
                left[index] = leftMaxPq.peek();
            }
            else{
                left[index] = leftMinPq.peek();
            }
            index++;
        }

        PriorityQueue<Integer> rightMaxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMinPq = new PriorityQueue<>();

        right[n-1] = A[n-1];
        right[n-2] = ( ((double)A[n-1]+ A[n-2]) / 2 );

        rightMaxPq.offer(Math.min(A[n-1] , A[n-2]));
        rightMinPq.offer(Math.max(A[n-1] , A[n-2]));
       
        index = n-3;

        for(int i=n-3 ; i>=0; i--){

                if( A[i] <= rightMaxPq.peek()){

                rightMaxPq.offer(A[i]);

                if( rightMaxPq.size() - rightMinPq.size() > 1){
                    rightMinPq.offer(rightMaxPq.poll());
                }
            }
            else{
                rightMinPq.offer(A[i]);

                if( rightMinPq.size() - rightMaxPq.size() > 1){
                    rightMaxPq.offer(rightMinPq.poll());
                }
            }

            if( rightMaxPq.size() == rightMinPq.size()){
                right[index] = ( (double)rightMaxPq.peek() + rightMinPq.peek() ) / 2;
            }
            else if( rightMaxPq.size() > rightMinPq.size()){
                right[index] = rightMaxPq.peek();
            }
            else{
                right[index] = rightMinPq.peek();
            }
            index--;
        }

       
        for(int i=0; i<n; i++){

            if( i==0 ){
                if((double)A[i] == right[i+1]){
                    return 1;
                }
            }
            else if( i==n-1 ){
                if( (double)A[i] == left[n-2]){
                    return 1;
                }
            }
            else{
                if((double)A[i] == left[i-1] || (double)A[i] == right[i+1]){
                    return 1;
                }
            }
        }
        return 0;
    }
	public int solve2(ArrayList < Integer > A) {
        ArrayList < Integer > clone = new ArrayList < > ();
        ArrayList < Double > preMedian = new ArrayList < > ();
        ArrayList < Double > postMedian = new ArrayList < > ();
        for (int i = 0; i < A.size(); i++) clone.add(A.get(i));
        solve2(clone, preMedian);
        Collections.reverse(clone);
        solve2(clone, postMedian);
        Collections.reverse(postMedian);
        for (int i = 0; i < A.size(); i++) {
                if (i > 0 && preMedian.get(i - 1) == (double) A.get(i) ||
                        i < (A.size() - 1) && postMedian.get(i + 1) == (double) A.get(i)) return 1;
        }
        return 0;
}

private void solve2(ArrayList < Integer > A, ArrayList < Double > ans) {
        PriorityQueue < Integer > maxHeap = new PriorityQueue < > ();
        PriorityQueue < Integer > minHeap = new PriorityQueue < > ();
        for (int i = 0; i < A.size(); i++) {
                int elem = A.get(i);
                if (maxHeap.isEmpty()) {
                        maxHeap.add(-elem);
                } else if (elem <= -maxHeap.peek()) {
                        maxHeap.add(-elem);
                        if (maxHeap.size() - minHeap.size() > 1) minHeap.add(-maxHeap.poll());
                } else if (elem > -maxHeap.peek()) {
                        minHeap.add(elem);
                        if (minHeap.size() - maxHeap.size() > 0) maxHeap.add(-minHeap.poll());
                }
                if (maxHeap.size() != minHeap.size()) {
                        ans.add((double) (-maxHeap.peek() + 0));
                } else {
                        ans.add((-maxHeap.peek() + minHeap.peek()) / 2.0);
                }
        }
}
public int solve3(ArrayList<Integer> A) {

    PriorityQueue<Integer> lft = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> ryt = new PriorityQueue<>();

    for(int i = 0; i < A.size() - 1; i++) {
        double median = -1;
        if(lft.size() == ryt.size()) {
            ryt.add(A.get(i));
            lft.add(ryt.poll());
            median = (double)lft.peek();
        } else {
            lft.add(A.get(i));
            ryt.add(lft.poll());
            median = (lft.peek() + ryt.peek())/2.0;
        }
        if(median == A.get(i + 1)){
            return 1;
        }
    }

    lft.clear();
    ryt.clear();

    for(int i = A.size() - 1; i > 0; i--) {
        double median = -1;
        if(lft.size() == ryt.size()) {
            ryt.add(A.get(i));
            lft.add(ryt.poll());
            median = (double)lft.peek();
        } else {
            lft.add(A.get(i));
            ryt.add(lft.poll());
            median = (lft.peek() + ryt.peek())/2.0;
        }
        if(median == A.get(i - 1)){
            return 1;
        }
    }

    return 0;
}
static PriorityQueue < Integer > maxHeap;
static PriorityQueue < Integer > minHeap;
public int solveScalerSol(int[] A) {
  int n = A.length;
  minHeap = new PriorityQueue();
  maxHeap = new PriorityQueue(new CustomCompScalerSol1());
  for (int i = 0; i < (n - 1); i++) {
    add_numberScalerSol(A[i]);
    if (A[i + 1] == find_medianScalerSol()) return 1;
  }
  minHeap = new PriorityQueue();
  maxHeap = new PriorityQueue(new CustomCompScalerSol1());
  for (int i = n - 1; i > 0; i--) {
    add_numberScalerSol(A[i]);
    if (A[i - 1] == find_medianScalerSol()) return 1;
  }
  return 0;
}
public static void add_numberScalerSol(int num) {
  maxHeap.offer(num);
  minHeap.offer(maxHeap.peek());
  maxHeap.poll();
  if (maxHeap.size() < minHeap.size()) {
    maxHeap.offer(minHeap.peek());
    minHeap.poll();
  }
}
public static int find_medianScalerSol() {
  if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
  else {
    int ans = maxHeap.peek() + minHeap.peek();
    if (ans % 2 != 0) return Integer.MAX_VALUE; //answer is a fraction
    else return ans / 2;
  }
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpecialMedian sm = new SpecialMedian();
		int[] A = {4, 6, 8, 4};
		System.out.println(sm.solve(A)); // 1
		System.out.println(sm.solveMine(A));
		int[] B = {2, 7, 3, 1};
		System.out.println(sm.solve(B)); // 0
		System.out.println(sm.solveMine(B));
		int[] C = {2147483647,-2147483648,0};
		System.out.println(sm.solve(C)); // 0
		System.out.println(sm.solveMine(C)); // 0
		int[] D = {-990467,990500,-990724,-990358,990464,990145,990827,990491,990942,990436,-990604,-990153,990382,-990716,990895,990726,990538,990912,990299,990894,-990811,990333,990664,990711,990868,-990644,990757,990859,990741,-990778,-990035,-990842,-990106,-990942,-990648,-990805,-990729,-990350,990101,990548,-990623,-990954,-990840,990376,-990308,-990439,990323,-990538,990082,990541,990115,-990658,990930,990306,990386,-990745,-990072,990829,990573,-990512,990290,990636,990767,990574,-990052,990150,-990724,990430,990191,990337,990287,990383,990909,990758,-990588,-990946,990030,-990168,-990591,-990655,-990359,-990537,990483,-990041,990350,-990836,-990020,-990021,-990199,990484,990734,-990999,-990938,990788,-990467,-990893,990483,-990421,990617,990514,990616,-990451,990249,-990556,-990303,-990008,990609,990702,990485,990343,-990587,-990503,-990200,-990618,-990796,990281,990798,-990157,-990622,-990292,-990179,-990657,990191,-990888,-990511,-990634,-990055,-990646,990886,990433,-990142,990416,-990998,990651,990699,-990476,990389,-990712,990510,990869,990688,990789,-990423,-990585,-990285,990426,-990757,990932,990154,-990189,-990329,990692,-990555,990549,990512,-990060,990753,990423,990996,990529,-990437,990949,990195,-990416,-990105,990282,-990734,-990701,-990671,990263,990355,-990053,-990808,990945,990756,-990558,990982,-990144,990222,990161,990450,-990466,-990659,990439,-990024,990510,-990649,-990313,-990022,990018,-990905,-990391,990625,-990414,-990824,-990874,990159,990070,-990297,990177,990270,-990668,-990985,990480,-990627,990099,990625,990924,990972,990181,990432,990593,-990031,-990142,-990286,990900,990360,-990974,990170,990833,-990760,990667,-990550,990694,990624,-990125,-990694,990302,-990466,990593,-990484,990464,-990152,-990087,-990926,-990757,-990315,990227,-990758,-990109,990086,990487,990474,990627,990928,-990520,990962,990596,990261,-990525,-990260,-990116,990326,990771,990547,-990520,-990924,-990763,-990851,-990829,-990713,990578,990007,-990200,990439,990760,990324,990108,990887,-990850,990428,990384,990540,990704,-990356,990350,-990485,-990216,-990357,990357,990271,-990361,990022,990112,990696,990041,990129,990565,-990932,990855,-990962,-990734,990972,-990369,990963,990483,990635,990848,990938,-990142,990511,990175,990825,-990870,990934,-990783,990398,990701,990734,-990534,-990993,-990705,990548,990300,990641,-990855,990462,-990877,-990678,-990443,-990673,990313,-990072,990610,-990932,990695,-990831,990488,990090,-990589,990145,990314,-990740,990258,-990759,-990605,990181,990829,-990608,990997,990556,990627,990541,990240,990174,990077,990683,-990992,-990601,-990759,990428,990084,-990786,990970,-990847,990503,-990663,-990363,990171,-990240,990542,990913,-990704,-990232,990205,990539,-990422,-990247,990648,990864,990075,-990712,990678,990262,990985,990944,990540,-990508,990870,-990323,-990472,-990087,990763,990103,-990527,990969,-990565,990543,990088,990637,990463,-990681,-990342,990060,-990758,-990888,990690,-990843,-990620,-990067,990783,990226,990038,-990629,990748,990359,-990766,-990955,990726,990025,990001,-990496,-990515,990342,-990913,-990196,-990072,990606,-990429,-990705,990812,990093,-990036,-990141,-990994,-990652,-990838,990355,-990131,990841,990011,-990186,-990650,990634,-990353,-990452,990262,990454,990634,-990256,990124,990213,-990028,-990080,-990858,990155,990264,990676,-990909,990561,-990948,-990653,-990220,990923,-990369,-990259,990619,990003,-990781,990392,-990313,-990589,990938,990410,-990234,990961,990493,990269,-990869,990700,990264,990215,-990815,-990039,-990288,990954,-990710,-990774,990815,990541,-990679,990898,990788,-990132,990689,990008,990790,-990363,-990184,990200,-990885,990071,990867,-990295,-990825,-990629,990598,-990693,-990080,990249,990528,990864,-990405,-990816,-990726,990087,-990964,990686,990662,990064,-990415,-990873,990941,990762,-990531,-990268,990602,990307,-990012,-990630,-990809,-990556,-990293,-990152,-990345,990248,990712,990114,-990958,990704,990052,-990479,-990423,990866,-990498,-990196,-990633,-990022,990392,990925,-990458,-990807,-990830,-990600,-990799,-990448,990540,-990575,-990567,-990397,-990897,-990851,990230,-990925,-990229,-990940,-990147,990655,990792,-990754,-990146,-990946,-990569,990663,990515,990475,-990528,990570,990464,990962,990524,-990469,-990923,990333,990910,990336,990278,-990636,990164,990949,990505,990004,-990623,-990970,990568,-990085,-990373,-990194,-990826,990572,-990640,990819,990611,990289,990565,-990585,990450,-990609,990166,990074,990300,990573,-990161,-990968,-990031,-990426,-990422,-990779,-990552,990391,-990764,-990364,-990255,-990474,-990821,990547,990789,-990195,990950,990754,-990012,-990439,-990912,-990967,-990415,990223,-990434,990486,990958,-990806,990700,990692,-990532,990974,990021,990222,990376,990948,-990982,-990776,-990111,-990856,-990925,990486,990969,990534,-990668,-990991,-990783,-990727,990871,990612,-990027,-990545,-990185,990237,990313,-990850,-990111,-990149,990454,990681,990267,-990793,-990472,990830,990442,-990877,-990702,-990381,990823,990023,990595,-990327,-990310,-990058,-990487,990528,990258,990860,-990286,-990610,-990128,-990841,990503,-990865,990881,-990750,-990598,990661,990756,990278,990435,-990075,990386,-990360,-990048,990492,-990840,-990735,990599,-990892,-990328,-990369,-990794,990252,990432,-990208,990497,990649,990841,-990100,990648,-990851,990633,-990200,990990,-990919,990578,-990544,990487,990525,-990538,-990193,-990011,-990834,990497,-990529,990805,-990392,-990549,990979,990277,-990193,-990497,-990276,-990582,-990159,990489,-990449,-990072,990008,990208,-990503,-990607,-990074,990611,-990761,990890,-990683,-990932,-990741,-990813,-990396,-990615,-990599,-990680,990032,-990584,-990517,990670,990882,-990523,990105,-990095,-990916,990178,990058,990750,990729,-990995,990676,-990899,990565,-990608,990243,-990514,990055,-990973,990748,-990986,990446,990517,-990916,990791,-990912,990693,990815,-990857,-990052,990551,-990226,990955,-990394,990097,990065,-990261,-990078,990140,990947,990170,-990489,990149,-990865,990282,-990432,-990367,-990882,990641,990187,990479,990538,-990447,-990646,990759,-990422,990486,-990028,990860,-990777,990503,-990431,990455,-990106,-990821,990281,990455,-990124,-990135,990774,-990998,-990253,990635,990888,990232,-990680,-990678,990801,990199,-990363,990573,990245,-990274,990353,990287,990110,-990465,990529,-990112,990381,990890,-990805,990032,990320,-990431,-990293,-990578,990206,-990166,-990697,990694,990788,990984,990978,-990015,-990684,-990906,-990097,990390,-990785,-990199,990710,990813,-990085,990580,990267,-990444,-990507,-990827,-990431,-990271,990693,990337,990604,-990406,990022,-990000,-990537,990388,990289,990181,990584,990761,990217,990482,990665,-990104,990095,-990221,-990781,-990106,990343,-990080,990868,-990713,-990251,-990079,990040,990933,990663,-990653,990095,-990874,-990835,990976,990725,990808,-990156,990832,990440,990562,-990962,990836,-990202,-990080,-990076,-990493,-990546,990773,990880,-990072,990707,990666,990588,990168,990396,-990009,990136,990762,990742,-990922};
		System.out.println(sm.solve(D)); // 0 -- 1
		System.out.println(sm.solveMine(D)); // 1
	}

}
class CustomCompScalerSol1 implements Comparator < Integer > {
	  @Override
	  public int compare(Integer a, Integer b) {
	    return b - a;
	  }
	}