package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9663 {
	static int n;
	static int count;
	static int[] selected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		check(1);
		System.out.println(count); 
	}

	private static boolean isTrue(int row, int i, int c, int selected) {
		if(i==selected) return true;
		//오른쪽 대각선 체크
		if(row-i == c-selected) return true;
		//왼쪽 대각선 체크
		if(row+i == c+selected) return true;
		return false;
	}
	
	private static void check(int row) {
		if(row == n+1) {
			count++;
		}else {
			for(int i=1; i<=n; i++) {
				boolean count = true; 
				for(int c=1; c<=row-1; c++) {
					//유효성체크
					if(isTrue(row,i,c,selected[c])) {
						count = false;
						break;
						
					}
				}
				if(count) {
					selected[row] = i;
					check(row+1);
					selected[row] = 0;
				}
				
			}
			
		}
		
	}

	

	private static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		selected = new int[n+1];
		br.close();
		
	}

}
