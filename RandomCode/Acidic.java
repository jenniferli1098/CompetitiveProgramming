import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Info {
	public int num;
	public int count;

	public Info(int r) {
		num = r;
		count = 0;
	}

	public void add() {
		count++;
	}
}

public class Acidic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		Info[] A = new Info[1001];
		for (int i = 0; i < 1001; i++) {
			A[i] = new Info(i);
		}

		int N = input.nextInt();
		for (int i = 0; i < N; i++) {
			int k = input.nextInt();
			A[k].add();
		}
		// sorts
		Arrays.sort(A, new Comparator<Info>() {

			@Override
			public int compare(Info a, Info b) {
				if (a.count < b.count) {
					return 1;
				} else if (a.count > b.count) {
					return -1;
				} else {
					return a.num - b.num;
				}
			}
		});

		int maxDi;
		// if more than one
		if (A[0].count == A[1].count) {
			int k = 1;
			 maxDi = 0;
			while (A[k].count == A[0].count) {
				maxDi = Math.max(Math.abs(A[0].num - A[k].num), maxDi);
				k++;
			}
		} else {
			// two different
			 maxDi = 0;
			int k = 1;
			while (A[k].count == A[1].count) {
				maxDi = Math.max(Math.abs(A[0].num - A[k].num), maxDi);
				k++;
			}
			
		}
		System.out.println(maxDi);
	}

}
