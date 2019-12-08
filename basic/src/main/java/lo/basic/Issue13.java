package lo.basic;

import java.util.Arrays;

public class Issue13 {
	public static void main(String[] args) {
		int[] data = { 5, 5, 6, 6, 78, 78, 78, 9487, 9487, 9487, 9487, 65535 };
		int[] result = longest(data);
		int[] result_v2 = longest_v2(data);
		int[] result_v3 = longest_v3(data);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result_v2));
		System.out.println(Arrays.toString(result_v3));

	}

	/**
	 * @param data 已經排序過的 array
	 * @return result[0] 是最長平台的數字，result[1] 是長度
	 */

	private static int[] longest(int[] data) {
		int counter = 1;
		int max_counter = 0;
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

	private static int[] longest_v2(int[] data) {
		int i = 0;
		int ii = 1;
		int number = 0;
		int max_counter = 0;
		while (ii < data.length) {
			if (data[i] != data[ii]) {
				if (ii - i > max_counter) {
					max_counter = ii - i;
					number = data[i];
				}
				i = ii;
			}
			ii += 1;
		}
		if (ii - i > max_counter) {
			max_counter = ii - i;
			number = data[i];
		}

		return new int[] { number, max_counter };
	}

	private static int[] longest_v3(int[] data) {
		int number = 0;
		int i = 0;
		int ii = 0;
		int counter = 1;
		int max_counter = 0;
		do {
			if (data[i] == data[ii]) {
				counter += 1;
			} else {
				counter = 1;
				i = ii;
			}
			if (counter > max_counter) {
				max_counter = counter;
				number = data[i];
			}
			ii += 1;
		} while (ii < data.length);
		return new int[] { number, max_counter };
	}
}