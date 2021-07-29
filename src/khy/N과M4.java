package khy;

import java.io.*;
import java.util.*;



public class N과M4 {

	static int n;
	static int m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		input();
		func(1);
		System.out.println(sb);
	}
	
	public static void func(int depth) {
		if(depth == m+1) {
			for(int i = 1; i<=m; i++){
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		} else {
			int start = selected[depth-1];
			if(start == 0) start = 1;
			for(int cand = start; cand<=n ; cand++) {
				selected[depth] = cand;
				func(depth+1);
				selected[depth] = 0;
			}
		}
		
	}
	
	
	
	
	public static void input() throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st =  new StringTokenizer(str);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m+1];
	}
}
