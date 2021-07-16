package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No2667 {
	
	static int n;
	static int count;
	static String[] houseMap;
	static ArrayList<Integer> house = new ArrayList<Integer>();
	static boolean[][] check;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}}; //{오,아,왼,위}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		//1. 값 입력받기
		input();
 		
		//2. 탐색(Bfs,dfs)
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j] && houseMap[i].charAt(j)=='1') {
					count =0;
					dfs(i,j);
					house.add(count);
				}
			}
		}
		Collections.sort(house);
		sb.append(house.size()).append("\n");
		for(int i:house) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y) {
		count++;
		check[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];
			
			//범위를 벗어날때
			if(nx<0 || ny<0 || nx>n-1 || ny>n-1) continue;
			//방문했거나 조건에 안맞음
			if(check[nx][ny] || houseMap[nx].charAt(ny)=='0') continue;
			dfs(nx,ny);
		}
		
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		check = new boolean[n][n];
		houseMap = new String[n];
		//값입력
		for(int i=0; i<n; i++) {
				houseMap[i] = br.readLine();
		}
		
		
	}
}
