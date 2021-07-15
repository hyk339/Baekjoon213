package ksb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Atm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		HashMap<Integer, Integer> map =  new HashMap<>();
		for(int i=1;i<=n;i++) {
			map.put(i, sc.nextInt());
		}
		List<Integer> KeySetList = new ArrayList<>(map.keySet());
		Collections.sort(KeySetList, (o1,o2)->(map.get(o1).compareTo(map.get(o2))));
	
		int tmp=0;
		int res=0;
		for(int j=0; j<n;j++) {
			//System.out.println(map.get(KeySetList.get(j)));
			tmp+=map.get(KeySetList.get(j));
			res+=tmp;
			
		}
		System.out.println(res);
		
		
		
		sc.close();
	}
}
