import java.util.Scanner;

public class HashString {
	static long A = 911382323;
	static long B = 972663749;
	static long mod = Long.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s= input.nextLine();
		long sum = 0;
		long coeff = 1;
		for(int i = 0; i < s.length();i++) {
			coeff = coeff*A%mod;
			sum = (sum+s.charAt(i)*coeff%mod)%mod;
		}
		long hashVal = sum%B;
		

	}

}
