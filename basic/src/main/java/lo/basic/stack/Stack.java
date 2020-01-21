package lo.basic.stack;

/**
 * 跟 #16 有什麼差異：
 * <ol>
 * 	<li>從 StackCaller 的角度看，無法知道各 method 裡面寫了什麼。</li>
 * 	<li>caller 能用 Stack __ = new Stack(); 建立實際上不一樣但是功能一樣的Stack，各自不相干擾的Stack。</li>
 * 	<li>caller 的介面(？ 欸...不知道怎麼稱呼= =+)（StackCaller.java)）看起來比較簡潔，<br>
 * 		沒有一長串定義 method 的程式碼。</li>
 * 	<li>能限定存取權限，例如 field 開成 private 可以避免 值（例如：index） 從該 class 以外的地方直接被改掉。</li>
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
		index = stack.length;
	}

	public void push(int num) {
		stack[index] = num;
		index += 1;
		if (index >= stack.length) {
			changeLength(stack.length * 2);
		}
	}

	/**
	 * 因為 pop() 比 push() 多了「可能是 caller 非預期的例外狀況」，故需要特別說明。<br>
	 * 例如
	 * <ol>
	 * 	<li>列印出警示</li>
	 * 	<li>index < 0 的情況下會傳回 stack[0]的值。</li>
	 * </ol>
	 * <ol>
	 * 	<li>若 index = 0 仍繼續執行 pop()，將列印警示、將 index = 0 並傳回 stack[index]。</li>
	 * 	<li>若 index < stack.length / 3、且 stack 的長度 > 10，將呼叫 changeLength()，使 stack 長度減半。</li>
	 * </ol>
	 * index 在小於 stack 總長度一半的 2/3 時，改變 stack 的總長度。<br>
	 * new stack 的長度為 old stack 長度的一半，<br>
	 * 將 pop 改變長度的臨界點設為 總長度一半的 2/3，（push 是 達到長度最大值後，長度變長兩倍）<br>
	 * 讓 stack 長度減為一半後，仍保有目前 1/3 的 stack 長度可以 push 而不會立即呼叫 changelength()，<br><br>
	 * 若 pop 和 push 改變長度的臨界點相同，有可能使 stack 長度頻繁增減。<br><br>
	 * 另外將條件設為 stack.length > 10 才會動作，讓 stack 最小長度不會小於 10。<br>
	 * 綜合以上兩點能使 stack 長度不會因為重複的 push 後 pop、push 後 pop...而改變長度。
	 * @return 由 index 指向s stack[] 內第幾個位置的值。
	 */
	public int pop() {
		index -= 1;
		if (index < 0) {
			lastOne();
			index = 0;
		} else if (index < stack.length / 3 && stack.length > 10) {
			changeLength(stack.length / 2 < 10 ? 10 : stack.length / 2);
		}
		return stack[index];
	}

	private void changeLength(int length) {
		int[] tmp = stack;
		stack = new int[length];
		for (int i = 0; i < index; i++) {
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
