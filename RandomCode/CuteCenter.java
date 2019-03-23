import java.util.Arrays;
import java.util.Scanner;

public class CuteCenter {
	
	
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int x = input.nextInt();
		int [] arr = new int[n];
		int firstI = -1;
		int lastI = -1;
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
			
		}
		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			if(arr[i] ==x) {
				if(firstI<0) {
					firstI = i;
					lastI = firstI;
				}else {
					lastI=i;
				}
			}
		}
		int count = 0;
		int numI = lastI-firstI+1;
		//case 1: 1 x
		if(numI>0&&firstI>0) {
			count+=(firstI+1)*(numI)*(n-lastI-1);
		}
		//case 2: 2x
		if(numI>=2) {
			count+=(numI*(numI-1)/2)*(n-numI);
		}
		//case 3: 3x
		if(numI>=3) {
			count+=(numI*(numI-1)*(numI-2)/3);
		}
		
		System.out.println(count);
	}
}
