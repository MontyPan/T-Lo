package lo.basic;

public class Fibonacci {
	public static void main(String[] args) {
		test(0, 1, 10, 55);
		test(1, 2, 8, 55);
		test(1, 5, 20, 38006);
		test(100, 101, 1, 100);
		test(88, 99, 2, 99);
		test_whileLoop(0, 1, 10, 55);
		test_whileLoop(1, 2, 8, 55);
		test_whileLoop(1, 5, 20, 38006);
		test_whileLoop(100, 101, 1, 100);
		test_whileLoop(88, 99, 2, 99);
		test_whileLoop(1, 1, 3, 3);
	}

	/**
	 * a[n] = a[n-1] + a[n-2]
	 * 
	 * @return 第 n 項的值
	 * forLoop() 可能會有哪些問題或是不討 caller 喜愛的部份?
	 * → 相較於 while loop 需要多設立 for ( S1; S2; S3) 所使用的變數來控制 loop 次數。
	 * 
	 * →→ 因為「不討 caller 喜愛的部份」 那這裡 caller 指的應該是人?
	 * →→ 那我認為 for-loop 的問題大概是 很難用，像我這種低智商的要用 for-loop 寫出較簡便的程式碼，
	 * →→ 就得花許多時間去想 nested for-loop 上下間彼此變數的關係來控制迴圈次數，
	 * →→ （還是其實只有我覺得難用＝　＝...）
	 * →→ 如果在 因為不同輸入而得產生不同迴圈次數 、或者 未能事先知道得做幾次迴圈次數 的情況下會更燒腦，
	 * →→ 相比 while 迴圈只要設立停止條件並避免無窮迴圈即可，大概是這樣吧。
	 *
	 * →→→ Optional question 選擇不回答。（正確來說是答不出來）
	 */
	private static int forLoop(int a0, int a1, int n) {
		int result = 0;
		if (n == 1) {
			result = a0;
		} else if (n == 2) {
			result = a1;
		} else if (n > 2) {
			for (int i = 1; i < n; i++) {
				result = a0 + a1;
				a0 = a1;
				a1 = result;
			}
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

	private static int whileLoop(int a0, int a1, int n) {
		int result = 0;
		int i = 1;
		if (n == 1) {
			result = a0;
		} else if (n == 2) {
			result = a1;
		} else if (n > 3) {
			while (i < n) {
				result = a0 + a1;
				a0 = a1;
				a1 = result;
				i += 1;
			}
		}
		return result;
	}

	private static void test_whileLoop(int a0, int a1, int n, int answer) {
		if (answer == whileLoop(a0, a1, n)) {
			System.out.println("pass");
		} else {
			System.out.println("FAIL");
		}
	}
}
