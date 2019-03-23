import java.util.Scanner;

public class AliceThroughTheLookingGlass {

	public static boolean filled(int m, int x, int y) {
		if(m>=1) {
			int factor = (int) Math.pow(5,m-1);
			int x1 = x/factor;
			int y1 = y/factor;
			if(((x1 ==1)||(x1 ==2)||(x1 ==3))&&(y1==0)) {
				return true;
			}else if(x1==2&&y1==1) {
				return true;
			}
			
			if(y1==1&&(x1==1||x1==3)||(y1==2&&x1==2)) {
				return filled(m-1,x%factor,y%factor);
			}
			
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++) {
			int m = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			
			if(filled(m,x,y)) {
				System.out.println("crystal");
			}else {
				System.out.println("empty");
			}
		}

	}

}
