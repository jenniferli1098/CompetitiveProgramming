import java.text.DecimalFormat;
import java.util.*;
public class Triangles {
	public static class Point {
		public double x,y;
		public Point(double a, double b) {
			x = a;
			y = b;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DecimalFormat df = new DecimalFormat("#.##");
		//System.out.println(df.format(100.000));
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		Point [] arr = new Point[N];
		for(int i = 0; i < N; i++) {
			arr[i] = new Point(input.nextDouble(),input.nextDouble());
		}
		ArrayList<Double> ps= new ArrayList<>();
		Map <Double, Long> mp = new HashMap<>();
		//mp.put(new Point(2,3), 1);
		//System.out.println(mp.containsKey(new Point(2,3)));
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				double m = 2.342344;
				double b = arr[i].x;
				if(arr[i].x-arr[j].x!=0) {
				m = (arr[i].y-arr[j].y)/(arr[i].x-arr[j].x);
				//System.out.println(m);
				b = arr[i].y-m*arr[i].x;
				}
				double t = 0.34223*m+b;
				if(mp.containsKey(t)) {
					mp.put(t, mp.get(t)+1);
				}else {
					mp.put(t, (long) 1);
					ps.add(t);
				}
				
				
			}
		}
		//System.out.println(ps.size());
		long sum = N*(N-1)*(N-2)/6;
		for(int i = 0; i < ps.size();i++) {
			//System.out.println(mp.get(ps.get(i)));
			long k = mp.get(ps.get(i));
			long n = (int) (Math.sqrt(2*k)+1);
			sum-=n*(n-1)*(n-2)/6;
		}
		System.out.println(sum);
		
	
	}

}
