package lo.basic;

import java.util.Arrays;

public class Issue13 {
	public static void main(String[] args) {
		int[] data = { 5, 5, 6, 6, 78, 78, 78, 9487, 9487, 9487, 9487, 65535 };
		int[] result = longest(data);
		int[] result_v4 = longest_v4(data);
		int[] result_v5 = longest_v5(data);
		int[] result_v6 = longest_v6(data);
		int[] result_v7 = longest_v7(data);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result_v4));
		System.out.println(Arrays.toString(result_v5));
		System.out.println(Arrays.toString(result_v6));
		System.out.println(Arrays.toString(result_v7));
		int[] bugTest_2 = { 3, 5, 6, 7, 8, 99, 300 };
		int[] answer_test_2 = { 3, 1 };
		System.out.println("第一個數字數量最多的情況： ");
		System.out.println("數字數量都是 1 的情況： ");
		System.out.println("修正後為 ：" + test(longest_v5(bugTest_2), answer_test_2));
	}

	/**
	 * @param data 已經排序過的 array
	 * @return result[0] 是最長平台的數字，result[1] 是長度
	 */

	private static int[] longest(int[] data) {
		int counter = 1;
		int max_counter = 1;
		int number = data[0];
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] == data[i + 1]) {
				counter += 1;
				if (counter > max_counter) {
					max_counter = counter;
					number = data[i];
				}
			} else {
				counter = 1;
			}
		}
		return new int[] { number, max_counter };
	}

	private static int[] longest_v4(int[] data) {
		int i = 0;
		int number = 0;
		int max_counter = 0;
		for (int ii = 1; ii < data.length; ii++) {
			if (ii - i + 1 > max_counter) {
				max_counter = ii - i;
				number = data[i];
				if (data[i] == data[data.length - 1]) {
					max_counter += 1;
					number = data[ii];
				}
			}
			if (data[i] != data[ii]) {
				i = ii;
			}
		}
		return new int[] { number, max_counter };
	}

	private static int[] longest_v5(int[] data) {
		int number = data[0];
		int counter = 1;
		int max_counter = 1;
		for (int i = 1; i < data.length; i++) {
			counter += 1;
			if (data[i] != data[i - 1]) {
				counter = 1;
			}
			if (counter > max_counter) {
				max_counter = counter;
				number = data[i];
			}
		}
		return new int[] { number, max_counter };
	}

	private static int[] longest_v6(int[] data) {
		int counter = 0;
		int number = data[0];
		int max_counter = 0;
		int max_number = data[0];
		for (int i = 0; i < data.length; i++) {
			counter += 1;
			if (data[i] == number && counter > max_counter) {
				max_counter = counter;
				max_number = number;
			} else if (data[i] != number) {
				number = data[i];
				counter = 1;
			}
		}
		return new int[] { max_number, max_counter };
	}

	private static int[] longest_v7(int[] data) {
		int max = 0;
		int num = data[0];
		int counter = 1;
		for (int i = 1; i < data.length; i++) {
			if (data[i] == data[i - 1]) {
				counter += 1;
				continue;
			}
			if (counter > max) {
				max = counter;
				num = data[i - 1];
			}
			counter = 1;
		}
		if (counter > max) {
			max = counter;
			num = data[data.length - 1];
		}
		return new int[] { num, max };
	}

	private static boolean test(int[] value, int[] answer) {
		System.out.println("value = " + Arrays.toString(value));
		System.out.println("answer = " + Arrays.toString(answer));
		return value[0] == answer[0] && value[1] == answer[1];
	}
}