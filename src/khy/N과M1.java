package khy;

import java.io.*;
import java.util.*;


public class N과M1 {
	
	static int n;
	static int m;
	static int[] selected;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		input();
		func(1);
		System.out.println(sb);
	}
	
	static void func(int index) {
		if(index == m+1) {
			for(int i=1; i<=m; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		}else {
			for(int cand = 1; cand<=n ; cand++) {
				if(used[cand] == true) continue;
				selected[index] = cand;
				used[cand] = true;
				func(index+1);
				used[cand] = false;
				selected[index] = 0;
			}
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m+1];
		used = new boolean[n+1];
	} 
}
