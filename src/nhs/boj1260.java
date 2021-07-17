package nhs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {
	
	static int N; // 정점
	static int M; // 간선
	static int v; // 시작 정점
	static int[][] arr; // 인접행렬
	static boolean[] visit; // 방문체크
	static StringBuffer sb = new StringBuffer();
	static Queue<Integer> que = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input();
		dfs(v);
		wr.write(sb.toString());
		wr.write("\n");
		for(int i=0; i<visit.length; i++) {
			visit[i] = false;
		}
		
		sb.delete(0,sb.length());
		bfs(v);
		wr.write(sb.toString());
		
		wr.flush();
		wr.close();
	}
	
	private static void bfs(int from) {
		que.add(from);
		visit[from] = true;
		
		while(!que.isEmpty()) {
			
			int x = que.poll();
			sb.append(x).append(" ");
		
			for(int j=1; j<=N; j++) {
				if(arr[x][j] == 0) continue;
				if(visit[j] == true) continue;
				
				que.add(j);
				visit[j] = true;
			}
		}
	}

	private static void dfs(int from) {
		
		sb.append(from).append(" ");
		visit[from] = true;
		
		for(int to=1; to<=N; to++) {
			if(arr[from][to] == 0) continue;
			if(visit[to] == true) continue;
			
			dfs(to);
		}
	}

	public static void input() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		
		StringTokenizer token = new StringTokenizer(num);
		
		N = Integer.parseInt(token.nextToken()); // 정점
		M = Integer.parseInt(token.nextToken()); // 간선
		v = Integer.parseInt(token.nextToken()); // 시작 정점
		
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		br.close();
	}
}
