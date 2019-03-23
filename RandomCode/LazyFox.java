import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LazyFox{
	public static class Triple implements Comparable <Triple>{
		public int dist;
		public int a;
		public int b;
		public Triple(int dist, int a, int b) {
			this.dist = dist;
			this.a = a;
			this.b = b;
			
		}
		public int compareTo( Triple b) {
            if(dist>b.dist) {
    			return 1;
    		}else if(dist<b.dist) {
    			return -1;
    		}
    		return 0;
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Comparator<Triple> tripComparator = new Comparator<Triple>() {
            @Override
            public int compare(Triple a, Triple b) {
                if(a.dist>b.dist) {
        			return 1;
        		}else if(a.dist<b.dist) {
        			return -1;
        		}
        		return 0;
            }
        };*/

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int point [][] = new int [N][2];
        for(int i = 0; i < N; i++) {
        	point[i][0] = input.nextInt();
        	point[i][1] = input.nextInt();
        }
        ArrayList<Triple> edge = new ArrayList<>();
        
        for(int i = 0; i < N-1; i++) {
        	for(int j = i+1; j< N; j++) {
        		int dx = point[i][0]-point[j][0];
        		int dy = point[i][1]-point[j][1];
        		edge.add(new Triple((dx*dx+dy*dy),i,j));
        	}
        }

        int [] best = new int[N];
        int [] dist = new int[N];
        //PriorityQueue<Integer> haha = new PriorityQueue<>();
        int max = 0;
       Collections.sort(edge);
       // edge.sort();
        
        for(int i = 0; i < edge.size();i++) {
        	Triple t = edge.get(i);
        	int a = t.a;
        	int b = t.b;
        	int dis = t.dist;
        	int tbest[] = new int[N];
        	if(dis>dist[a]&&best[b]<best[a]+1) {
        		tbest[b] = best[a]+1;
        	}
        	if(dis>dist[b]&&best[a]<best[b]+1) {
        		tbest[a] = best[b]+1;
        	}
        	if(best[b]<tbest[b]) {
        		dist[b] = dis;
        		best[b] = tbest[b];
        		if(max<best[b]&&dist[b]<(point[b][0]*point[b][0]+point[b][1]*point[b][1])) {
        			max = best[b];
        		}
        	}
        	if(best[a]<tbest[a]) {
        		dist[a] = dis;
        		best[a] = tbest[a];
        		if(max<best[a]&&dist[a]<(point[a][0]*point[a][0]+point[a][1]*point[a][1])) {
        			max = best[a];

        		}
        	}
        	
        }
        
       
        System.out.println(1+max);
        

	}

}