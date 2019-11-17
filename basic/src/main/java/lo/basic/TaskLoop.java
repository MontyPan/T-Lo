package lo.basic;

public class TaskLoop {
	public static void main(String[] args) {
		issue5(15);	//Delete
	}

	private static void issue5(int input) {
		System.out.println("start");

		for (int i = 0; i < input; i++) {
			for (int ii = 0;ii < input; ii++) {
				System.out.print("*" );
			}
			System.out.println();
		}

		System.out.println("end");
	}
}
