package yjm;

public class TargetNumber {
	int count;
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		TargetNumber tn = new TargetNumber();
		int result = tn.solution(numbers, 3);
		System.out.println(result);
		
	}
	public int solution(int[] numbers, int target) {
        int answer = 0;
    	dfs(numbers,target,0,0);
        answer = count;        
        return answer;
    }
    public void dfs(int[] numbers, int target, int depth, int sum) {
    	if(depth==numbers.length) {
    		if(sum==target) {
    			count++;
    		}
            return;
    	}
    	dfs(numbers,target,depth+1,sum+numbers[depth]);
    	dfs(numbers,target,depth+1,sum-numbers[depth]);
    }
}
