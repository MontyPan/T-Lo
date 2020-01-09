package lo.basic.stack;

public class Stack {

	int index = 0;
	int[] stack;

	public Stack() {
		stack = new int[10];
	}

	public Stack(int[] args) {
		stack = args;
	}

	public void push(int num) {
		stack[index] = num;
		index += 1;
		if (index >= stack.length) {
			addLength();
		}
	}

	public int pop() {
		index -= 1;
		if (index < 0) {
			lastOne();
			index = 0;
		}
		return stack[index];
	}

	private void addLength() {
		int[] tmp = stack;
		stack = new int[index * 2];
		for (int i = 0; i < tmp.length; i++) {
			stack[i] = tmp[i];
		}
	}

	private void lastOne() {
		System.out.println("It's last one!");
	}

	public void showLength() {
		System.out.println(stack.length);
	}

	public void whatIsNext() {
		System.out.println(stack[index]);
	}
}
