import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
class command implements Comparable{
	public int y1;
	public int y2;
	public long t;
	public int x;
	public command(int y1, int y2, long t, int x) {
		this.y1=y1;
		this.y2=y2;
		this.t= t;
		this.x = x;
	}
	@Override
	   public int compareTo(Object o) {
	       int result =  (this.x < ((command) o).x? -1 : (this.x == ((command) o).x ? 0 : 1));
	       
	       return  result;
	   }
}
public class TintedGlassWindow{
	public static int n;
	public static int A[];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		TreeSet<Integer> yVals = new TreeSet<Integer>();
		//ArrayList<Integer> yVals = new ArrayList<Integer>();
		TreeSet<Integer> xVals = new TreeSet<Integer>();
		int N = input.nextInt();
		int T = input.nextInt();
		command [] coms = new command[2*N];
		for(int i = 0; i < N; i++) {
			int x1 = input.nextInt();
			int y1 = input.nextInt();
			int x2 = input.nextInt();
			int y2 = input.nextInt();
			long t  = input.nextInt();
			//update from (y1,y2) +t at x1
			//update from (y1,y2) -t at x2
			yVals.add(y1);
			yVals.add(y2);
			xVals.add(x1);
			xVals.add(x2);
			coms[i*2] = new command(y1,y2,t,x1);
			coms[i*2+1] = new command(y1,y2,-t,x2);
		}
		Arrays.sort(coms);
		//System.out.println(yVals.get(0)+" "+yVals.get(N-1));
		//System.out.println(coms[0].x+" "+coms[2*N-1].x);
		n = yVals.size()+1;
		A = new int[n+1];
		//build(1,0,n);
		long windows = 0;
		long cur = 0;
		for(int i = 0; i+1 < coms.length; i++) {
			int y1 = coms[i].y1;
			int y2 = coms[i].y2;
			int x = coms[i].x;
			long t = coms[i].t;
			//System.out.println(y1+" "+y2+" "+x+" "+t);
			//update tints
			int s = yVals.headSet(y1).size();
			int e = yVals.headSet(y2).size();

			int height = y1;
			for(int k =  s; k <e; k++) {
				A[k]+=t;
				if((A[k]-t)<T&&A[k]>=T) {
					cur+=yVals.ceiling(height+1)-yVals.floor(height);
				}else if((A[k]-t)>=T&&A[k]<T) {

					cur-=yVals.ceiling(height+1)-yVals.floor(height);
				}
				height = yVals.ceiling(height+1);
			}
			//System.out.println(cur);
			windows+=cur*(coms[i+1].x-x);
		}
		System.out.println(windows);
		
		
	}

}