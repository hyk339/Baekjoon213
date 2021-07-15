package khy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS인접리스트 {

	static int n;
	static int m;
	static int v;
	static ArrayList<Integer>[] arr;
	static StringBuilder sb = new StringBuilder();
	static Boolean[] visited;
	static Queue<Integer> list = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		input();
		dfs(v);
		
		sb.append('\n');
		for(int i=0;i<visited.length;i++) {
			visited[i] = false;
		}
		bfs(v);
		
		System.out.println(sb);
	}
	

	private static void dfs(int num) {
		sb.append(num).append(' ');
		visited[num] = true;
		
		for(int a : arr[num]) {
			
			if(visited[a]) {
				continue;
			}
			dfs(a);
		}
	}

	private static void bfs(int num) {
		sb.append(num).append(' ');
		list.add(num);
		visited[num] = true;
		
		while(!list.isEmpty()) {
			num = list.poll();
			for(int a : arr[num]) {
				
				if(visited[a]) {
					continue;
				}
				sb.append(a).append(' ');
				list.add(a);
				visited[a] = true;
			}
		}
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visited = new Boolean[n+1];
		arr = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(arr[i]);
		}
		
		
		for(int i=0;i<n+1;i++) {
			visited[i] = false;
		}
	}
}
