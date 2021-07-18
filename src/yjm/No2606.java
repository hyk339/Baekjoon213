package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2606 {
	static ArrayList<ArrayList<Integer>> com;
	static Queue<Integer> que;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		int result = bfs(1);
		System.out.println(result);
	}

	private static int bfs(int startNum) {
		int count = 0;
		que = new LinkedList<Integer>();
		
		que.add(startNum);
		check[startNum] = true;
		while(!que.isEmpty()) {
			int n = que.poll();
			
			for(int network :com.get(n)) {
				if(check[network]) continue;
				que.add(network);
				check[network] = true;
				count++;
			}
		}
		return count;
	}

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int v = Integer.parseInt(br.readLine());
		
		check = new boolean[n+1];
		//입접리스트 생성
		com = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<n+1; i++) {
			com.add(new ArrayList<Integer>());
		}
		
		//그래프 간선연결
		int n1=0;
		int n2=0;
		for(int i=0; i<v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n1 =Integer.parseInt(st.nextToken());
			n2 =Integer.parseInt(st.nextToken());
			
			com.get(n1).add(n2);
			com.get(n2).add(n1);
		}
		
		//그래프
		for(ArrayList<Integer> test:com) {
			System.out.println(test);
		}
	}

}
