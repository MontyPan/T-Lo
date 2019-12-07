package lo.basic;

public class Issue12 {

	public static void main(String[] args) {
		int input = 5;
		v1(input);
		v2(input);
		v3(input);
	}

	public static void v1(int x) {
		System.out.println("v1");
		int counter = 1;
		for (int i = 0; i < x; i++) {
			for (int i2 = i + 1; i2 < x; i2++) {
				System.out.print(" ");
			}
			for (int i3 = 0; i3 <= i * 2; i3++) {
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
		System.out.println("\nv2");
		int counter = 1;
		for (int i = 0; i < x; i++) {
			for (int ii = 0; ii < x * 2 - 1; ii++) {
				if (ii < x - i - 1 || ii > x + i - 1) {
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
		System.out.println("\nv3");
		int[] list = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = 1;
		int limit = x * 2;
		for (int i = 1; i < limit; i += 2) {
			for (int i2 = 1; i2 < limit - i; i2 += 2) {
				System.out.print(" ");
			}
			for (int i4 = 0; i4 < i; i4++) {
				if (index > 9) {
					index = 0;
				}
				System.out.print(list[index]);
				index += 1;
			}
			System.out.println();
		}
	}
}