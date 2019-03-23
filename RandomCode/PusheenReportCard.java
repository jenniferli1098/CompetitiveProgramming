import java.util.*;
public class PusheenReportCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[][] arr = new int[N][N];
		for(int i =0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j]= input.nextInt();
			}
		}
		boolean f = false;
		for(int i =0; i+1 < N; i++) {
			for(int j = 0; j+1 < N; j++) {
				if(arr[i][j]+1!=arr[i][j+1]) {
					int a = 1;
					int b = Math.min(N-i-1;
					int size = (a+b)/2;
					while(a!=b) {
						if(arr[i+size][j]+1!=arr[i+size][j+1]) {
							a = size;
						}else {
							b=  size;
						}
						size = (a+b)/2;
					}
					System.out.println(size+1);
					f = true;
				}
				if(f) {
					break;
				}
			}
			if(f) {
				break;
			}
		}
	}

}
