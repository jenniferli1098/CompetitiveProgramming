import java.util.*;
public class NailedIt {

	public static int perm(int a,int t) {
		return a*perm(a-1,t-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		int [] arr = new int[2001];
		int [] lens = new int[4002];
		int N = input.nextInt();
		for(int i = 0; i < N; i++) {
			int k = input.nextInt();
			if(lengths.indexOf(k)<0) {
				lengths.add(k);
			}
			arr[k]++;
		}

		lengths.sort(null);
		for(int i = 0; i< lengths.size(); i++) {
			for(int j = i; j<lengths.size();j++) {
				int A = lengths.get(i);
				int B = lengths.get(j);
				if(A==B) {
					lens[2*A]+=arr[A]/2;
				}else {
					lens[A+B]+=Math.min(arr[A], arr[B]);
				}
				
			}
		}
		int max = 0;
		int maxP = 0;
		for(int i = 0; i < 4002;i++) {
			if(lens[i]==max) {
				maxP++;
			}
			if(lens[i]>max) {
				max = lens[i];
				maxP=1;
			}
		}
		System.out.println(max+" "+maxP);
	}

}
