package level3;

public class Main {

	public static void main(String[] args) {
		GoldAndSilver gas = new GoldAndSilver();
		int a = 10;
		int b = 10;
		int[] g = new int[] {100};
		int[] s = new int[] {100};
		int[] w = new int[] {7};
		int[] t = new int[] {10};
		long answer = gas.solution(a, b, g, s, w, t);
		System.out.println("Gold And Silver Answer: " + answer);

	}

}
