package lo.basic;

public class Issue12 {

	public static void main(String[] args) {
		int input = 5;
		System.out.println("v1");
		v1(input);
		System.out.println("v2");
		v2(input);
		System.out.println("v3");
		v3(input);
		System.out.println("v4");
		v4(input);
		System.out.println("v5");
		v5(input, new char[] {'5', '4', '8', '7'});
	}

	public static void v1(int x) {
		int counter = 1;
		for (int i = 0; i < x; i++) {
			for (int i2 = i + 1; i2 < x; i2++) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 <= i * 2; i2++) {
				if (counter < 9) {
					System.out.print(counter);
					counter += 1;
				} else {
					System.out.print(counter);
					counter = 0;
				}
			}
			System.out.println();
		}
	}

	public static void v2(int x) {
		int counter = 1;
		for (int i = 0; i < x; i++) {
			for (int i2 = 0; i2 < x * 2 - 1; i2++) {
				if (i2 < x - i - 1 || i2 > x + i - 1) {
					System.out.print(" ");
				} else {
					if (counter < 9) {
						System.out.print(counter);
						counter += 1;
					} else {
						System.out.print(counter);
						counter = 0;
					}
				}
			}
			System.out.println();
		}
	}

	public static void v3(int x) {
		int[] list = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = 1;
		int limit = x * 2;
		for (int i = 1; i < limit; i += 2) {
			for (int i2 = 1; i2 < limit - i; i2 += 2) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 < i; i2++) {
				if (index > 9) {
					index = 0;
				}
				System.out.print(list[index]);
				index += 1;
			}
			System.out.println();
		}
	}

	/**
	 * L89 直接寫 10 這個數字不恰當，像是之前提過的 magic 9，
	 * 應該寫 list.length，這樣與變數 list 的長度才有關連性。
	 */
	public static void v4(int x) {
		int[] list = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = 1;
		int limit = x * 2;
		for (int i = 1; i < limit; i += 2) {
			for (int i2 = 1; i2 < limit - i; i2 += 2) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 < i; i2++) {
				System.out.print(list[index]);
				index = (index + 1) % 10;
			}
			System.out.println();
		}
	}

	/**
	 * v5 傳入的 array 可以為空的 array，
	 * 例如 v5(input, new char[] {})，
	 * 程式會執行但是會發生被除數為 0 的錯誤。
	 */
	public static void v5(int x, char[] array) {
		int index = 0;
		int limit = x * 2;
		for (int i = 1; i < limit; i += 2) {
			for (int i2 = 1; i2 < limit - i; i2 += 2) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 < i; i2++) {
				System.out.print(array[index % array.length]);
				index = index + 1;
			}
			System.out.println();
		}
	}
}