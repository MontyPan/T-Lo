package lo.basic;

public class Fibonacci {
	public static void main(String[] args) {
		test(0, 1, 10, 55);
		test(1, 2, 8, 55);
		test(1, 5, 20, 38006);
		test(100, 101, 1, 100);
		test(88, 99, 2, 99);
	}

	/**
	 * a[n] = a[n-1] + a[n-1] → 應該是 a[n] = a[n-1] + a[n-2] ?
	 * 
	 * @return 第 n 項的值
	 */
	
	private static int forLoop(int a0, int a1, int n) {
		int result = 0;
		if (n > 2) {
			for (int i = 1; i < n; i++) {
				result = a0 + a1;
				a0 = a1;
				a1 = result;
			}
		} else if (n == 2) {
			result = a1;
		} else if (n == 1) {
			result = a0;
		}
		return result;
	}

	private static void test(int a0, int a1, int n, int answer) {
		if (answer == forLoop(a0, a1, n)) {
			System.out.println("pass");
		} else {
			System.out.println("FAIL");
		}
	}
}
