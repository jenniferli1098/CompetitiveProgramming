import java.util.*;
public class KeeponTrucking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int [] d = {0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};
		ArrayList<Integer>pos = new ArrayList<>();
		for(int i = 0; i < 14; i++) {
			pos.add(d[i]);
		}
		int A = input.nextInt();
		int B = input.nextInt();
		int m = input.nextInt();
		for(int i = 0; i < m; i++) {
			pos.add(input.nextInt());
		}

		int [] dp = new int[pos.size()];
		pos.sort(null);
		dp[0] = 1;
		for(int i = 1; i < pos.size(); i++) {
			System.out.println(pos.get(i));
			for(int k = i-1; k >= 0; k--) {
				if(pos.get(i)-pos.get(k)>=A&&pos.get(i)-pos.get(k)<=B) {
					dp[i]+=dp[k];
				}
				if(pos.get(i)-pos.get(k)>B) {break;}
			}
		}
		System.out.println(dp[pos.size()-1]);
		
	}

}
