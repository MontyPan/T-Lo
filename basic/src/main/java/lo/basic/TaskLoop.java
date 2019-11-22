package lo.basic;

public class TaskLoop {
	public static void main(String[] args) {
		issue7_1(3);
		issue7_2(3);
		issue7_3(3);
	}

	private static void issue7_1(int input_1) {
		System.out.println("start_1");
		for (int i = 0; i < input_1; i++) {
			for (int ii = 0; ii <= i; ii++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = 0; i < input_1 - 1; i++) {
			for (int ii = 1; ii < input_1 - i; ii++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("end_1");
	}

	private static void issue7_2(int input_2) {
		System.out.println("start_2");
		for (int i = input_2; i > 0; i--) {
			for (int ii = input_2 - i; ii >= 0; ii--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = input_2; i > 1; i--) {
			for (int ii = i - 1; ii >= 1; ii--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("end_2");
	}

	private static void issue7_3(int input_3) {
		System.out.println("start_3");
		int[] ls = new int[input_3 * 2 - 1];
		for (int i = 0; i < input_3; i++) {
			ls[i] = i + 1;
		}
		for (int i = input_3; i < input_3 * 2 - 1; i++) {
			ls[i] = input_3 * 2 - i - 1;
		}
		for (int i = 0; i < input_3 * 2 - 1; i++) {
			for (int ii = 0; ii < ls[i]; ii++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("end_3");
	}
}
