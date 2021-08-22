package yjm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class No1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		int num = Integer.valueOf(line);
		
		ArrayList<Integer> arr = new ArrayList<>();
		int n = 0;
		for(int i=0; i<line.length(); i++) {
			arr.add(num%10);
			num /= 10;
		}
		Collections.sort(arr,new Comparator<Integer>() {
			public int compare(Integer s1, Integer s2) {
				return s2-s1;
			}
		});
		for(int output:arr) {
			sb.append(output);
		}
		
		System.out.println(sb);
	}
}
