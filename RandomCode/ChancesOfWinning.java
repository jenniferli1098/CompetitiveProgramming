import java.util.*;
public class ChancesOfWinning {
	public static int A;
	public static String s = "121314232434";
	public static int chances(int scores, String state) {
		if(state.indexOf("1")<0) {
			//System.out.println(scores);
			//see if valid
			int max = 0;
			int ind = -1;
			int tt = scores;
			for(int i = 1; i <= 4; i++) {
				int x = tt%10;

				//System.out.print(x+" ");
				tt/=10;
				if(x>max) {
					ind = i;
					max = x;
				}
			}
			//System.out.println();
			if(ind==A) {
				tt = scores;
				int count = 0;
				for(int i = 0; i <  4; i++) {
					int x = tt%10;
					tt/=10;
					if(x==max) {
						count++;
					}
				}
				if(count==1) {
					return 1;
				}
			}
			return 0;
		}
		int sum = 0;
		for(int i = 0; i < 6; i++) {
			if(state.substring(i, i+1).equals("1")) {
				int a = Integer.parseInt(s.substring(i*2,i*2+1));
				int b = Integer.parseInt(s.substring(i*2+1,i*2+2));
				String temp = state.substring(0,i)+"0"+state.substring(i+1);
				sum+=chances(scores+3*(int)Math.pow(10, b-1),temp);
				sum+=chances(scores+3*(int)Math.pow(10, a-1),temp);
				sum+=chances(scores+(int)Math.pow(10, b-1)+(int)Math.pow(10, a-1),temp);

				return sum;
			}
		}
		return 0;
		
	}
	//12,13,14,23,24,34
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//boolean [] state = new boolean[6];
		String state = "111111";
		A = input.nextInt();
		int M = input.nextInt();
		int sum = 0;
		for(int i = 0; i < M; i++) {
			int a,b,sa,sb;
			a = input.nextInt();
			b = input.nextInt();
			String game=  a+""+b;
			state = state.substring(0,s.indexOf(game)/2)+"0"+state.substring(s.indexOf(game)/2+1);
			//state[s.indexOf(game)/2] = true;
			sa = input.nextInt();
			sb = input.nextInt();
			if(sa>sb) {
				sum+=3*(int)Math.pow(10,a-1);
			}else if(sb>sa) {
				sum+=3*(int)Math.pow(10,b-1);
			}else {
				sum+=(int)Math.pow(10,b-1)+(int)Math.pow(10,a-1);
			}
		}
		System.out.println(chances(sum,state));
	}

}
