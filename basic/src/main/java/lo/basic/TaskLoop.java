package lo.basic;

public class TaskLoop {
	public static void main(String[] args) {

		int totalInput = 5;
		issue5(totalInput);
		issue7_1(totalInput);
		issue7_2(totalInput);
		issue7_3(totalInput);
		issue7_4(totalInput);
	}

	private static void issue5(int input) {
		System.out.println("start");
		for (int i = 0; i < input; i++) {
			for (int ii = 0; ii < input; ii++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("end");
	}

	private static void issue7_1(int input) {
		System.out.println("start_1");
		for (int i = 0; i < input; i++) {
			for (int ii = 0; ii <= i; ii++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = 0; i < input - 1; i++) {
			for (int ii = 1; ii < input - i; ii++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("end_1");
	}

	private static void issue7_2(int input) {
		System.out.println("start_2");
		for (int i = input; i > 0; i--) {
			for (int ii = input - i; ii >= 0; ii--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = input; i > 1; i--) {
			for (int ii = i - 1; ii >= 1; ii--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("end_2");
	}

	private static void issue7_3(int input) {
		System.out.println("start_3");
		int[] list = new int[input * 2 - 1];
		for (int i = 0; i < input; i++) {
			list[i] = i + 1;
		}
		for (int i = input; i < list.length; i++) {
			list[i] = input * 2 - i - 1;
		}
		for (int i = 0; i < list.length; i++) {
			for (int ii = 0; ii < list[i]; ii++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("end_3");
	}
	private static void issue7_4(int input) {
		System.out.println("start_4");
		int a = input * 2;
		for (int i = 1; i < a; i++) {
		    for (int ii = 0; ii < i && i <= input; ii++) {
		        System.out.print("*");
		    }
		    for (int ii = a - i; ii > 0 && i > input; ii--) {
		    //for (int ii = i; a - ii > 0 && i > input; ii++) {
		        System.out.print("*");
		    }
		    System.out.println();
		}
		System.out.println("end_4");
	}
}
