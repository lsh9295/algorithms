import java.util.Stack;

class Solution {
	public static String solution(int n) {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		String answer = "";
		while (n > 0) {
			if (n % 3 == 0) {
				stack.push(4);
				n /= 3;
				n--;
			}
			else {
				stack.push(n % 3);
				n /= 3;
			}
		}
		while (!stack.isEmpty())
		   {
				sb.append(stack.pop());
		   }
		return sb.toString();
	}
}