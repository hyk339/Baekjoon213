package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15649 {
	static int n;
	static int m;
	static int[] selected;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		input();
		search(1);
		System.out.println(sb);
	}

	private static void search(int depth) {
		//if(마지막 깊이때)
		//append
		if(depth == m+1) {
			for(int i=1; i<=m; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		}else {
		//for(n까지){
		//중복체크
		//재귀();
			for(int i=1; i<=n; i++) {
				
				if(used[i]) continue;
				
				selected[depth] = i;
				used[i] = true;
				search(depth+1);
				//selected[depth] = 0;
				used[i] = false;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m+1];
		used = new boolean[n+1];
		br.close();
	}

}
