package lo.basic;

public class Issue16 {

	static int[] stack = new int[10];

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
		stack[0] += 1;
		stack[stack[0]] = value;
	}

	private static int pop() {
		int tmp = stack[stack[0]];
		stack[0] -= 1;
		return tmp;
	}
}
