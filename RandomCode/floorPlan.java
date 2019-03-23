import java.util.*;

public class floorPlan {

	public static char[][] plan;
	public static boolean[][] vis;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int f = input.nextInt();
		int r = input.nextInt();
		int c = input.nextInt();
		input.nextLine();
		plan = new char[r][c];
		vis = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String s = input.nextLine();
			for (int k = 0; k < c; k++) {
				plan[i][k] = s.charAt(k);
				if (plan[i][k] == 'I') {
					vis[i][k] = true;
				}
			}
		}
		ArrayList<Integer> rooms = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			for (int k = 0; k < c; k++) {
				if (plan[i][k] == '.' && !vis[i][k]) {
					rooms.add(space(i, k));
				}
			}
		}

		int[] room = new int[rooms.size()];
		for (int i = 0; i < room.length; i++) {
			room[i] = rooms.get(i);
		}
		Arrays.sort(room);

		int num = room.length;

		int total = 1;
		while (total <= room.length && (f - room[room.length - total]) >= 0) {
			f -= room[room.length - total];
			total++;
		}
		total--;
		if (total == 1) {
			System.out.println(total + " room, " + f + " square metre(s) left over");
		} else {
			System.out.println(total + " rooms, " + f + " square metre(s) left over");
		}
	}

	public static int space(int r, int c) {
		vis[r][c] = true;
		int tot = 1;
		try {
			if (plan[r - 1][c] == '.' && !vis[r - 1][c]) {
				tot += space(r - 1, c);
			}
		} catch (Exception e) {

		}
		try {
			if (plan[r + 1][c] == '.' && !vis[r + 1][c]) {
				tot += space(r + 1, c);
			}
		} catch (Exception e) {

		}
		try {
			if (plan[r][c - 1] == '.' && !vis[r][c - 1]) {
				tot += space(r, c - 1);
			}
		} catch (Exception e) {

		}
		try {
			if (plan[r][c + 1] == '.' && !vis[r][c + 1]) {
				tot += space(r, c + 1);
			}
		} catch (Exception e) {

		}
		return tot;

	}
}
