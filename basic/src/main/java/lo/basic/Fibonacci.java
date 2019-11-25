package lo.basic;

public class Fibonacci {
	public static void main(String[] args) {
		test(0, 1, 10, 55);
		test(1, 2, 8, 55);
		test(1, 5, 20, 38006);
	}

	/**
	 * a[n] = a[n-1] + a[n-1]
	 *
	 * @return 第 n 項的值
	 */
	private static int forLoop(int a0, int a1, int n) {
		//假設 n 必定大於 2
		//當然你要參考下面 test() 把他補強至 n 必定大於 0 也很好

		int result = 0;

		//FIXME

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
