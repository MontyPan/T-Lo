package lo.basic.stack;

/**
 * 跟 #16 有什麼差異：
 * 1. 從 StackCaller 的角度看，無法知道各 method 裡面寫了什麼。
 * 2. caller 能用 Stack __ = new Stack(); 建立實際上不一樣但是功能一樣的 Stack，各自不相干擾的 Stack。
 * 3. caller 的介面(？　欸...不知道怎麼稱呼= =+)（StackCaller.java)）看起來比較簡潔，
 *    沒有一長串定義 method 的程式碼。
 * 4. 能限定存取權限，例如 field 開成 private 可以避免 值（例如：index） 從該 class 以外的地方直接被改掉。
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
	 * @return 回傳由 index 指向 stack[] 內第幾個位置的值
	 * @exception 若 index = 0 仍繼續執行 pop()，將列印警示、將 index = 0 並傳回 stack[index]。
	 *
	 * 因為 pop() 比 push() 多了「可能是 caller 非預期的例外狀況」，
	 * 例如 1. 列印出警示  2. index < 0 的情況下會傳回 stack[0]的值，
	 * 故需要特別說明。
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

	public void showLength() {
		System.out.println(stack.length);
	}

	/**
	 * A:可以先查看下一個 pop 的值 / 剛剛不小心 push 進去的值是什麼。
	 * (少打了 -1  Q_Q)
	 */
	public void whatIsNext() {
		System.out.println(stack[index-1]);
	}
}
