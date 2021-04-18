package company.sixt;
import java.util.Stack;

public class CalcualteParenthesisScoreStack {

	public static void main(String[] args) {
		//System.out.println("Score for ()()() :: " + getScores("()()()"));
		System.out.println("Score for (()) :: " + getScores("(())"));
		System.out.println("Score for ((()())) :: " + getScores("((()()))"));

	}

	public static int getScores(String data) {
		Stack<Character> s = new Stack<Character>();
		int score = 0;
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			if (ch == '(') {
				s.push(ch);
			} else {
				if (s.peek() == '(') {
					s.pop();
					s.push('1');
				} else {
					int val = 0;
					while (s.peek() != '(') {
						val += s.pop() - '0';
					}
					s.pop();
					val = val *2;
					s.push((char) (val + 48));
				}
			}
		}
		while(!s.isEmpty()) {
			score += s.pop() - '0';
		}

		return score;
	}

}
