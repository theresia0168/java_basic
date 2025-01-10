package practiceProject001;

public class Practice001 {

	public static String rf(String str, int index, boolean[] seen) {
		if(index < 0) return "";
		char c = str.charAt(index);	// d, c, b, a, c, a, b, a
		String result = rf(str, index-1, seen);
		if(!seen[c]) {
			seen[c] = true;
			System.out.println(result);
			return c + result;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "abacabcd";
		int length = str.length();	// 8
		boolean[] seen = new boolean[256];
		System.out.print(rf(str, length-1, seen));
	}

}
