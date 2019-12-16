package lo.basic;

public class Issue16 {
	
	static int[] stack = new int [10];
	
	public static void main(String[] args) {
		push(9);
		push(4);
		push(8);
		push(7);
		System.out.println(pop()); // 7
		System.out.println(pop()); // 8
		System.out.println(pop()); // 4
		push(7);
		push(8);
		System.out.println(pop()); // 8
	}
	
	private static void push(int value) {
		
	}

	private static int pop() {
		return Integer.MIN_VALUE; //fix
	}
}
