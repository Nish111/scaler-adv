package recursion_250123;
// https://www.scaler.com/academy/mentee-dashboard/class/50135/assignment/problems/15010/submissions
public class TowerOfHanoiAgain {

	    int temp=0;
		int[][] res; 
	    public int[][] towerOfHanoi(int A) {
		    res=new int[(1<<A)-1][3];
		    toh(A,1,2,3);
		    return res;
	    }
	    public void toh(int A,int source,int helper,int destination){
		    if(A==0)
		    return;
		    toh(A-1,source,destination,helper);
		    res[temp][0]=A;
		    res[temp][1]=source;
		    res[temp][2]=destination;
		    temp++;
		    toh(A-1,helper,source,destination);
		    return;
		}
	    int curr;
	    int[][]ans;
	    public int[][] towerOfHanoiScalerSol(int A) {
	        curr = 0;
	        int m = (1 << A) - 1;
	        ans = new int[m][3];
	        recScalerSol(A, 1, 3);
	        return ans;
	    }  
	    public void recScalerSol(int disk, int start, int end){
	        if(disk == 1){
	            ans[curr++] = new int[]{disk, start, end};
	            return;
	        }
	        // move top (disk - 1) disks from start to buffer, using end as a buffer
	        recScalerSol(disk - 1, start, 6 - start - end);
	        // move top from start to end
	        ans[curr++] = new int[]{disk, start, end};
	        // move top (disk - 1) disks from buffer to end, using start as a buffer
	        recScalerSol(disk - 1, 6 - start - end, end);
	    }
	}

