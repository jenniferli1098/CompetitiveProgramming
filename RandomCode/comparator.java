import java.util.*;
class Food{
	public int fill;
	public int tasty;
	public int index;
	public Food(int f, int t, int i) {
		fill = f;
		tasty = t;
		index = i+1;
	}
	
}
public class Hungry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		Food[] A = new Food[input.nextInt()];
		for(int i = 0; i < A.length; i++) {
			A[i] = new Food(input.nextInt(),input.nextInt(),i);
		}
		Arrays.sort(A,new Comparator<Food>() {
			public int compare(Food F1, Food F2) {
				return F1.fill-F2.fill;
			}
		});
		for(Food f:A) {
			System.out.print(f.index+" ");
		}
		System.out.println();
		Arrays.sort(A,new Comparator<Food>() {
			public int compare(Food F1, Food F2) {
				return F1.tasty-F2.tasty;
			}
		});
		for(Food f:A) {
			System.out.print(f.index+" ");
		}
		System.out.println();
	}

}
