package lo.basic;

import java.util.Arrays;

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

		for (int i = 0; i < 9487; i++) {
			push(i);
		}
		printStack(); 			// 列印 stack
		push(11); 				// index > 9, 從頭開始
		printStack(); 			// 列印
		allResetToZero(); 		// 全部還原成 arrays 的預設值 0
		printStack(); 			// 列印
		System.out.println(pop());
		changeIndex(5); 		// 指標換到第6位
		push(168); 				// 從第7位疊加 "168"
		System.out.println(pop());
		printStack(); 			// 列印
	}

	private static void push(int value) {
		if (index == stack.length - 1) {
			index = 0;
		} else {
			index += 1;
		}
		stack[index] = value;
	}

	private static int pop() {
		int tmp = stack[index];
		index -= 1;
		return tmp;
	}

	private static void allResetToZero() {
		for (int i = 0; i < stack.length; i++) {
			stack[i] = 0;
		}
		index = 0;
	}

	private static int changeIndex(int num) {
		if (num > 9) {
			System.out.println("Error!");
		} else {
			index = num;
		}
		return index;
	}

	private static void printStack() {
		System.out.println(Arrays.toString(stack));
	}
}
