package khy;

import java.io.*;
import java.util.*;


public class N과M1for {
	
	static int n;
	static int m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		input();
		func(1);
		System.out.println(sb);
		ArrayList arr = new ArrayList();
	
	}
	
	static void func(int index) {
		if(index == m+1) {
			for(int i=1; i<=m; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		}else {
			for(int cand = 1; cand<=n ; cand++) {
				boolean used = false;
				for(int i = 1; i<=m; i++) {
					if(selected[i] == cand) used = true;
				}
				if(!used) {
				selected[index] = cand;
				func(index+1);
				selected[index] = 0;
				}
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
	} 
}
