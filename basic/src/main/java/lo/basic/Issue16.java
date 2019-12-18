package lo.basic;

public class Issue16 {

	static int[] stack = new int[10];
	static int index = 0;
	public static void main(String[] args) {
		push(9);
		push(4);
		push(8);
		push(7);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		push(7);
		push(8);
		System.out.println(pop());
	}

	private static void push(int value) {
		index += 1;
		stack[index] = value;
	}

	private static int pop() {
		int tmp = stack[index];
		index -= 1;
		return tmp;
	}
}
