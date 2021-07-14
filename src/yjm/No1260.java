package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class No1260 { 
	static int n;
	static int m;
    static int v;
    static ArrayList<ArrayList<Integer>> grap;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		input();
		dfs(v-1);
		for(int i=0; i<n; i++) {
			check[i] = false; 
		}
		sb.append("\n");
		bfs(v-1);
		System.out.println(sb);
	}

	private static void dfs(int v) {
		
		check[v] = true;
		sb.append(v+1).append(" ");
		
		for(Integer i : grap.get(v)) {
			
			if(check[i]) {
				continue;
			}
			dfs(i);
		}
	}

	private static void bfs(int v) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		int x = 0;
		
		que.add(v);
		check[v] = true;
		
		while(!que.isEmpty()) {
			
			x = que.poll();
			sb.append(x+1).append(" ");
			
			for(Integer linkNode : grap.get(x)) {
				if(check[linkNode]) continue;
								
				que.add(linkNode);
				check[linkNode] = true;
			}
		}
		
		
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		check = new boolean[n];
		grap = new ArrayList<>();
		for(int i=0; i<n; i++) {
			grap.add(new ArrayList<Integer>());
		}
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			grap.get(x-1).add(y-1);
			grap.get(y-1).add(x-1);
		}
		for(ArrayList<Integer> arr: grap) {
			Collections.sort(arr);
		}
		
		br.close();
	}
}
