package lo.basic.stack;

import java.util.Arrays;

/**
 * 跟 #16 有什麼差異：
 * <ol>
 * <li>從 StackCaller 的角度看，無法知道各 method 裡面寫了什麼。</li>
 * <li>caller 能用 Stack __ = new Stack(); 建立實際上不一樣但是功能一樣的 Stack，各自不相干擾的Stack。</li>
 * <li>caller 的介面(？ 欸...不知道怎麼稱呼= =+)（StackCaller.java)）看起來比較簡潔，<br>沒有一長串定義 method 的程式碼。</li>
 * <li>能限定存取權限，例如 field 開成 private 可以避免 值（例如：index） 從該 class 以外的地方直接被改掉。</li>
 * </ol>
 */
public class Stack {

	private int index = 0;
	private int[] stack;

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

	/**
	 * 因為 pop() 比 push() 多了「可能是 caller 非預期的例外狀況」，故需要特別說明。<br>
	 * 例如
	 * <ol><li>列印出警示</li>
	 * <li>index < 0 的情況下會傳回 stack[0]的值。</li></ol>
	 *
	 * 若 index = 0 仍繼續執行 pop()，將列印警示、將 index = 0 並傳回 stack[index]。
	 *
	 * @return 由 index 指向 stack[] 內第幾個位置的值。
	 */
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

	public int showLength() {
		return stack.length;
	}

	/**
	 * @return 下一個 pop 的值，但是不從 stack 中移除。
	 */
	public int whatIsNext() {
		return stack[index-1];
	}
}
