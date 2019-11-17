package lo.basic;

public class TaskLoop {
	public static void main(String[] args) {
		int input = 15;

		System.out.println("start");	//可以砍掉

		for (int i = 0; i < input; i++) {
			for (int ii = 0;ii < input; ii++) {
				System.out.print("*" );	//不會換行
			}
			System.out.println();	//換行
		}

		System.out.println("end");	//可以砍掉
	}
}
