package khy;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;

public class 단지번호붙이기2 {
	
	static int n;
	static String[] a;
	static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	static ArrayList<Integer> group = new ArrayList();
	static int groupcount = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		pro();
	}

	public static void pro() {
		//외부에서 도는 for문
		//모든 이차원배열을 순회하며 확인한다.
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && a[i].charAt(j) == '1') {
				groupcount = 0;
				dfs(i,j);
				group.add(groupcount);
				}
			}
		}
		Collections.sort(group);
		System.out.println(group.size());
		for(int num :group) {
			System.out.println(num);
		}
		
	}
	
	public static void dfs(int n1, int n2) {
		groupcount++;
		visited[n1][n2] = true;
		for(int k=0; k<4; k++) {
			int nx = n1 + dir[k][1];
			int ny = n2 + dir[k][0];
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			if(a[nx].charAt(ny) == '0') continue;
			if(visited[nx][ny]) continue;
			dfs(nx,ny);
		}
	}
	
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new String[n];
		for(int i=0; i<n; i++) {
			a[i]= br.readLine();
		}
		visited = new boolean[n][n];
	}
}
