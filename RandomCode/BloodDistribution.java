import java.util.*;
public class BloodDistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int blood [] = new int[8];
		int patient [] = new int[8];
		for(int i = 0; i < 8; i++) {
			blood[i] = input.nextInt();
		}
		for(int i = 0; i < 8; i++) {
			patient[i] = input.nextInt();
		}
		int adj[][] = {{0},{1,0},{2,0},{3,2,1,0},{4,0},{5,4,1,0},{6,4,2,0},{7,6,5,4,3,2,1,0}};
		int units = 0;
		for(int i = 0; i < 8; i++) {
			for(int k = 0;k < adj[i].length; k++) {
				int w = Math.min(blood[adj[i][k]], patient[i]);
				blood[adj[i][k]]-=w;
				patient[i]-=w;
				units+=w;
			}
		}
		System.out.println(units);
	}

}
