import java.util.Scanner;

public class BellmanFord {

  public static int lengthOfLongestSubstring (int [] s) {
  int leftWindow = 0;
  int longest = 0;
  int [] counts = new int [s.length];
  
  for (int rightWindow = 0; rightWindow < s.length; ) {
    if (!counts[s[rightWindow]]) {
      counts[s[rightWindow]] = 0;
    }
    
    counts[s[rightWindow]] += 1;

    if (Object.values(counts).some((element) => element > 1)) {
      counts[s[leftWindow]] -= 1;
      leftWindow += 1;
    }
    
    longest = Math.max(longest, rightWindow - leftWindow + 1);
    rightWindow += 1;
  }

  return longest;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		edge [] edges = new edge[M];
		int dis[] = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			edges[i] = new edge(input.nextInt(),input.nextInt(), input.nextInt());
		}
		
		for(int i = 1;i <=N; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		dis[1] = 0;
		for(int i = 1; i < N; i++) {
			for(edge e: edges) {
				int a = e.a;
				int b = e.b;
				int w = e.w;
				dis[b] = Math.min(dis[b], dis[a]+w);
			}
		}
		
		//check for negative cycle
		boolean neg = false;
		for(edge e: edges) {
			int a = e.a;
			int b = e.b;
			int w = e.w;
			if(dis[b]> dis[a]+w){
				neg = true;
				break;
			}
		}
		if(neg) {
			System.out.println("negative cycle");
		}
		
	}

}
